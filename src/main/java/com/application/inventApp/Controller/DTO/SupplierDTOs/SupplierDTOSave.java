package com.application.inventApp.Controller.DTO.SupplierDTOs;

import jakarta.validation.constraints.Email;
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
public class SupplierDTOSave {

  @NotBlank(message = "El proveedor debe contar con un nombre")
  private String name;

  @Size(min = 10, max = 10, message = "El número de contacto debe tener 10 dígitos")
  private String numberPhone;

  @Email(message = "El proveedor debe contar con un correo válido")
  @NotBlank(message = "El proveedor debe contar con un correo")
  private String email;

  @NotBlank(message = "El proveedor debe contar con una direccion")
  private String address;

}
