package com.application.inventApp.Controller.DTO.UserDTOs;

import com.application.inventApp.Controller.DTO.ValidationCustom.PasswordValid;
import com.application.inventApp.Controller.DTO.ValidationCustom.RolValid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDTOSave {
  @NotBlank(message = "El usuario debe contar con un nombre")
  private String name;
  @PasswordValid
  private String password;
  @RolValid
  private String rol;

}
