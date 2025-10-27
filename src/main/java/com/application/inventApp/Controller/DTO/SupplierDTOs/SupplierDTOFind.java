package com.application.inventApp.Controller.DTO.SupplierDTOs;

import com.application.inventApp.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SupplierDTOFind {
  private UUID id;
  private String name;
  private String contact;
  private String email;
  private User user;
}
