package com.application.inventApp.Controller.DTO.ProductDTOs;

import java.math.BigDecimal;

import com.application.inventApp.Controller.DTO.ValidationCustom.MoneyValid;
import com.application.inventApp.Controller.DTO.ValidationCustom.ObjectValid;
import com.application.inventApp.Entity.Category;
import com.application.inventApp.Entity.Supplier;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
  @NotBlank(message = "La descripción no puede estar vacía")
  @Size(min = 20, max = 400, message = "La descripción debe tener como mínimo 20 caracteres y máximo 400")
  private String description;
  @NotNull(message = "El precio no puede ser nulo")
  @MoneyValid
  @Min(value = 1, message = "El precio debe tener 1 como valor mínimo")
  private BigDecimal price;
  @Min(value = 0, message = "El stock debe ser mayor o igual a 0")
  private int stock;
  @ObjectValid
  private Category category;
  @ObjectValid
  private Supplier supplier;
}
