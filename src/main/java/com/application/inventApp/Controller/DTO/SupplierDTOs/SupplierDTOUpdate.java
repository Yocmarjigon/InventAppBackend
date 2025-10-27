package com.application.inventApp.Controller.DTO.SupplierDTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SupplierDTOUpdate {
  @NotBlank(message = "El proveedor debe contar con un nombre")
  private String name;
  @NotBlank(message = "El proveedor debe tener un contact")
  private String contact;
  @Email(message = "El proveedor debe contar con un correo")
  private String email;
}
