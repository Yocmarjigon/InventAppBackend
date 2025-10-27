package com.application.inventApp.Controller.DTO.CategoryDTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CategoryDTOSave {
  @NotBlank(message = "La categoria debe contar con un nombre")
  private String name;

}
