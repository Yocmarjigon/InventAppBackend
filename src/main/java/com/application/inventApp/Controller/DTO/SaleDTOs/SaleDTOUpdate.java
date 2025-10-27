package com.application.inventApp.Controller.DTO.SaleDTOs;

import com.application.inventApp.Entity.Product;
import com.application.inventApp.Entity.User;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SaleDTOUpdate {
  @Min(value = 1, message = "El precio total debe tener 1 como valor minimo")
  private BigDecimal priceTotal;
  @Size(min = 1, message = "La venta debe tener por lo menos un producto")
  private List<Product> products;
  private User user;
}
