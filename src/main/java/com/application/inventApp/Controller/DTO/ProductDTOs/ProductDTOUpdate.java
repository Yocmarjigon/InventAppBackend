package com.application.inventApp.Controller.DTO.ProductDTOs;

import java.math.BigDecimal;

import com.application.inventApp.Controller.DTO.ValidationCustom.ObjectValid;
import com.application.inventApp.Entity.Category;
import com.application.inventApp.Entity.Supplier;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductDTOUpdate {
  @NotBlank(message = "El producto debe contar con un nombre")
  private String name;
  @Size(min = 20, max = 400, message = "La descripción tener como minimo 100 caracteres y maximo 400")
  private String description;
  @Min(value = 1, message = "El precio debe tener 1 como valor minimo")
  private BigDecimal price;
  private int stock;
  @ObjectValid
  private Category category;
  @ObjectValid
  private Supplier supplier;
}
