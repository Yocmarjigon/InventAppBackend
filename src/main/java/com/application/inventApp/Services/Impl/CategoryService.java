package com.application.inventApp.Services.Impl;

import com.application.inventApp.Entity.Category;
import com.application.inventApp.Exception.NotFoundException;
import com.application.inventApp.Repository.CategoryRepository;
import com.application.inventApp.Services.ICategoryService;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategoryService {

  @Autowired
  private CategoryRepository categoryRepository;

  @Override
  public List<Category> findAll() {
    return (List<Category>) categoryRepository.findAll();
  }

  @Override
  public Category findById(UUID id) {
    Optional<Category> optionalCategory = this.categoryRepository.findById(id);
    return optionalCategory.orElseThrow(() ->
      new NotFoundException("La categoria no existe")
    );
  }

  @Override
  public void save(Category category) {
    categoryRepository.save(category);
  }

  @Override
  public void update(UUID id, Category category) {
    Optional<Category> optionalCategory = categoryRepository.findById(id);
    if (optionalCategory.isPresent()) {
      Category categoryUp = optionalCategory.get();
      categoryUp.setName(category.getName());
      categoryRepository.save(categoryUp);
    }
    optionalCategory.orElseThrow(() ->
      new NotFoundException("La categoria no existe")
    );
  }

  @Override
  public void delete(UUID id) {
    Optional<Category> categoryOptional = categoryRepository.findById(id);
    if (categoryOptional.isPresent()) {
      categoryRepository.delete(categoryOptional.get());
    }
    categoryOptional.orElseThrow(() ->
      new NotFoundException("La categoria no existe")
    );
  }
}
