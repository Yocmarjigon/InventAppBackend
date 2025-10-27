package com.application.inventApp.Controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.inventApp.Controller.DTO.OrderDTOs.OrderDTOFind;
import com.application.inventApp.Controller.DTO.OrderDTOs.OrderDTOSave;
import com.application.inventApp.Controller.DTO.OrderDTOs.OrderDTOUpdate;
import com.application.inventApp.Controller.Response.ResponseOK;
import com.application.inventApp.Entity.Order;
import com.application.inventApp.Services.Impl.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/order")
public class OrderController {
  @Autowired
  private OrderService orderService;

  private ModelMapper modelMapper = new ModelMapper();

  @GetMapping("/find-all")
  public ResponseEntity<?> findAll() {
    List<OrderDTOFind> orders = orderService.findAll().stream().map(order -> modelMapper.map(order, OrderDTOFind.class))
        .toList();

    return ResponseEntity.ok(orders);

  }

  @GetMapping("/find-id/{id}")
  public ResponseEntity<?> findById(@PathVariable String id) {
    Optional<Order> orderOptional = orderService.findById(UUID.fromString(id));

    if (orderOptional.isPresent()) {
      Order order = orderOptional.get();
      OrderDTOFind orderDTO = modelMapper.map(order, OrderDTOFind.class);

      return ResponseEntity.ok(orderDTO);
    }
    return ResponseEntity.notFound().build();
  }

  @PostMapping("/save")
  public ResponseEntity<?> save(@Valid @RequestBody OrderDTOSave orderDTO, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return new ResponseEntity<>(new ResponseOK(bindingResult.getFieldError().getDefaultMessage()),
          HttpStatus.BAD_REQUEST);
    }
    Order order = modelMapper.map(orderDTO, Order.class);
    orderService.save(order);

    return ResponseEntity.ok(new ResponseOK("El pedido se completó correctamente"));
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<?> update(@PathVariable String id, @RequestBody OrderDTOUpdate orderDTO) {
    Order order = modelMapper.map(orderDTO, Order.class);

    Optional<Order> orderOptional = orderService.update(UUID.fromString(id), order);
    if (orderOptional.isPresent()) {
      return ResponseEntity.ok(new ResponseOK("El pedido se actualisó correctamente"));
    }
    return ResponseEntity.badRequest().build();
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> delete(@PathVariable String id) {
    Optional<Order> orderOptional = orderService.delete(UUID.fromString(id));
    if (orderOptional.isPresent()) {
      return ResponseEntity.ok(new ResponseOK("El pedido se eliminó corrctamente"));
    }
    return ResponseEntity.notFound().build();
  }
}
