package com.application.inventApp.Controller.DTO.ProductDTOs;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import com.application.inventApp.Controller.DTO.SupplierDTOs.SupplierDTOSave;
import com.application.inventApp.Entity.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductDTOFind {
  private UUID id;
  private String name;
  private String description;
  private BigDecimal price;
  private int stock;
  private Date dateAdd;
  private Category category;
  private SupplierDTOSave supplier;
}
