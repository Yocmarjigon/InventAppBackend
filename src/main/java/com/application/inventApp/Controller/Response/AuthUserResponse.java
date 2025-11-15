package com.application.inventApp.Controller.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Collection;


@AllArgsConstructor
@Data
@Builder
public class AuthUserResponse {
  private String name;
  private String message;
  private boolean status;
  private Collection<?> roles;
  private String jwt;
}
