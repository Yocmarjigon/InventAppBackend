package com.application.inventApp.Services.Impl;

import com.application.inventApp.Entity.Product;
import com.application.inventApp.Repository.ProductRepository;
import com.application.inventApp.Services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService implements IProductService {
  @Autowired
  private ProductRepository productRepository;

  @Override
  public List<Product> findAll() {
    return (List<Product>) productRepository.findAll();
  }

  @Override
  public Optional<Product> findById(UUID id) {
    return productRepository.findById(id);
  }

  @Override
  public void save(Product product) {
    productRepository.save(product);
  }

  @Override
  public Optional<Product> update(UUID id, Product product) {
    Optional<Product> productOptional = productRepository.findById(id);
    if (productOptional.isPresent()){
      Product productUp = Product.builder()
          .name(product.getName())
          .description(product.getDescription())
          .price(product.getPrice())
          .stock(product.getStock())
          .dateAdd(product.getDateAdd())
          .category(product.getCategory())
          .supplier(product.getSupplier())
          .build();
    }
    return productOptional;
  }

  @Override
  public Optional<Product> delete(UUID id) {
    Optional<Product> productOptional  = productRepository.findById(id);
    if(productOptional.isPresent()){
      productRepository.delete(productOptional.get());
    }

    return productOptional;
  }
}
