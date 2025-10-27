package com.application.inventApp.Controller.DTO.CategoryDTOs;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CategoryDTOFind {
  private UUID id;
  private String name;
}
