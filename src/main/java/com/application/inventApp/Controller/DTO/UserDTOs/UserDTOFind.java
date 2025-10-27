package com.application.inventApp.Controller.DTO.UserDTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDTOFind {
  private String name;
  private String password;
  private String rol;
}
