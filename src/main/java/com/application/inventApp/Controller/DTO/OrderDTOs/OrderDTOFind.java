package com.application.inventApp.Controller.DTO.OrderDTOs;

import com.application.inventApp.Controller.DTO.SupplierDTOs.SupplierDTOSave;
import com.application.inventApp.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderDTOFind {
  private UUID id;
  private Date date;
  private SupplierDTOSave supplier;
  private Date dateArrival;
  private User user;
}
