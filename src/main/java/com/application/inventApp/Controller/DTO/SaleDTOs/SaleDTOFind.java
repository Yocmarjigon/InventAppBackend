package com.application.inventApp.Controller.DTO.SaleDTOs;

import com.application.inventApp.Entity.Product;
import com.application.inventApp.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SaleDTOFind {
  private UUID id;
  private Date date;
  private BigDecimal priceTotal;
  private List<Product> products;
  private User user;
}
