package com.application.inventApp.Controller.DTO.SupplierDTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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

  @Min(value = 10, message = "El numero telefonico debe tener al menos 10 digitos")
  @Max(value = 10, message = "El numero telefonico debe tener maximo 10 digitos")
  private String numberPhone;

  @Email(message = "El proveedor debe contar con un correo")
  private String email;

}
