package com.application.inventApp.Controller.DTO.SupplierDTOs;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SupplierDTOFind {
  private UUID id;
  private String name;
  private String numberPhone;
  private String email;
}
