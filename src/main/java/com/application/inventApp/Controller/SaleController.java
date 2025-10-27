package com.application.inventApp.Controller;

import com.application.inventApp.Controller.DTO.SaleDTOs.SaleDTOFind;
import com.application.inventApp.Controller.DTO.SaleDTOs.SaleDTOSave;
import com.application.inventApp.Controller.DTO.SaleDTOs.SaleDTOUpdate;
import com.application.inventApp.Controller.Response.ResponseOK;
import com.application.inventApp.Entity.Sale;
import com.application.inventApp.Services.Impl.SaleService;
import com.auth0.jwt.exceptions.JWTVerificationException;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/sale")
public class SaleController {
  @Autowired
  private SaleService saleService;

  private ModelMapper modelMapper = new ModelMapper();

  @GetMapping("/find-all")
  public ResponseEntity<?> findAll() {

    List<SaleDTOFind> saleDTOS = saleService.findAll().stream().map(sale -> modelMapper.map(sale, SaleDTOFind.class))
        .toList();

    return ResponseEntity.ok(saleDTOS);
  }

  @GetMapping("/find-id/{id}")
  public ResponseEntity<?> findById(@PathVariable String id) {
    Optional<Sale> saleOptional = saleService.findById(UUID.fromString(id));
    if (saleOptional.isPresent()) {

      Sale sale = saleOptional.get();

      SaleDTOFind saleDTO = modelMapper.map(sale, SaleDTOFind.class);
      return ResponseEntity.ok(saleDTO);
    }
    return ResponseEntity.notFound().build();

  }

  @PostMapping("/save")
  public ResponseEntity<?> save(@Valid @RequestBody SaleDTOSave saleDTO, BindingResult bindingResult)
      throws JWTVerificationException {

    if (bindingResult.hasErrors()) {
      return new ResponseEntity<>(new ResponseOK(bindingResult.getFieldError().getDefaultMessage()),
          HttpStatus.BAD_REQUEST);
    }

    Sale sale = modelMapper.map(saleDTO, Sale.class);
    saleService.save(sale, saleDTO.getProducts());
    return ResponseEntity.ok(new ResponseOK("Venta creada correctamente"));

  }

  @PutMapping("/update/{id}")
  public ResponseEntity<?> update(@PathVariable String id, @RequestBody SaleDTOUpdate saleDTO) {
    Sale sale = modelMapper.map(saleDTO, Sale.class);
    Optional<Sale> saleOptional = saleService.update(UUID.fromString(id), sale);
    if (saleOptional.isPresent()) {
      return ResponseEntity.ok(new ResponseOK("La venta se actualizó correctamente"));
    }
    return ResponseEntity.notFound().build();
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> delete(@PathVariable String id) {
    Optional<Sale> saleOptional = saleService.delete(UUID.fromString(id));

    if (saleOptional.isPresent()) {
      return ResponseEntity.ok(new ResponseOK("La venta fue eliminada correctamente"));
    }

    return ResponseEntity.notFound().build();
  }

}
