package com.application.inventApp.Controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.inventApp.Controller.DTO.CategoryDTOs.CategoryDTOFind;
import com.application.inventApp.Controller.DTO.CategoryDTOs.CategoryDTOSave;
import com.application.inventApp.Controller.DTO.CategoryDTOs.CategoryDTOUpdate;
import com.application.inventApp.Controller.Response.ResponseOK;
import com.application.inventApp.Entity.Category;
import com.application.inventApp.Exception.NotFoundException;
import com.application.inventApp.Services.Impl.CategoryService;
import com.auth0.jwt.exceptions.JWTVerificationException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/category")
public class CategoryController {
  @Autowired
  private CategoryService categoryService;
  private ModelMapper modelMapper = new ModelMapper();

  @GetMapping("/find-all")
  public ResponseEntity<?> findAll() throws JWTVerificationException {
    List<CategoryDTOFind> categories = categoryService.findAll().stream()
        .map(category -> modelMapper.map(category, CategoryDTOFind.class)).toList();
    return ResponseEntity.ok(categories);
  }

  @GetMapping("/find-id/{id}")
  public ResponseEntity<?> findById(@PathVariable(name = "id") String id) {
    Optional<Category> categoryOptional = categoryService.findById(UUID.fromString(id));
    if (categoryOptional.isPresent()) {
      Category category = categoryOptional.get();
      CategoryDTOFind categoryDTO = modelMapper.map(category, CategoryDTOFind.class);
      return ResponseEntity.ok(categoryDTO);
    }
    throw new NotFoundException("Categoria no encontrada");
  }

  @PostMapping("/save")
  public ResponseEntity<?> save(@Valid @RequestBody CategoryDTOSave categoryDTO, BindingResult bindingResult) {
    if (bindingResult.hasFieldErrors()) {
      return new ResponseEntity<>(new ResponseOK(bindingResult.getFieldError().getDefaultMessage()),
          HttpStatus.BAD_REQUEST);
    }

    Category category = modelMapper.map(categoryDTO, Category.class);
    categoryService.save(category);
    return ResponseEntity.ok(new ResponseOK("La categoria fue creada correctamente"));

  }

  @PutMapping("/update/{id}")
  public ResponseEntity<?> update(@PathVariable String id, @RequestBody CategoryDTOUpdate categoryDTO) {
    Category category = modelMapper.map(categoryDTO, Category.class);
    Optional<Category> categoryOptional = categoryService.update(UUID.fromString(id), category);
    if (categoryOptional.isPresent()) {
      return ResponseEntity.ok(new ResponseOK("La categoria se actualizo correctamente"));
    }
    throw new NotFoundException("Categoria no encontrada");
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> delete(@PathVariable String id) {
    Optional<Category> categoryOptional = categoryService.delete(UUID.fromString(id));

    if (categoryOptional.isPresent()) {
      return ResponseEntity.ok(new ResponseOK("La categoria fue eliminada correctamente"));
    }
    throw new NotFoundException("Categoria no encontrada");
  }
}
