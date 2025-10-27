package com.application.inventApp.Controller.DTO.SaleDTOs;

import com.application.inventApp.Controller.DTO.ValidationCustom.ListObjectValid;
import com.application.inventApp.Entity.Product;
import com.application.inventApp.Entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SaleDTOSave {
  @ListObjectValid
  private List<Product> products;
  private User user;
}
