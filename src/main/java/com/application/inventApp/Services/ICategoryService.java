package com.application.inventApp.Services;

import com.application.inventApp.Entity.Category;
import java.util.List;
import java.util.UUID;

public interface ICategoryService {
    List<Category> findAll();
    Category findById(UUID id);
    void save(Category category);
    void update(UUID id, Category category);
    void delete(UUID id);
}
