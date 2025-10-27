package com.application.inventApp.Controller.DTO.OrderDTOs;

import java.util.Date;

import com.application.inventApp.Controller.DTO.ValidationCustom.DateValid;
import com.application.inventApp.Controller.DTO.ValidationCustom.ObjectValid;
import com.application.inventApp.Entity.Supplier;

import jakarta.validation.constraints.FutureOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderDTOSave {
  @ObjectValid(message = "El pedido debe tener un proveedor")
  private Supplier supplier;
  @DateValid(message = "El pedido debe contar con una fecha")
  @FutureOrPresent(message = "La fecha debe ser mayor o igual a la actual")
  private Date dateArrival;
}
