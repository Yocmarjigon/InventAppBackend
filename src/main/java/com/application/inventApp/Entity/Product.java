package com.application.inventApp.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "producto")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name = "nombre")
  private String name;
  @Column(name = "descripcion")
  private String description;
  @Column(name = "precio")
  private BigDecimal price;
  private int stock;
  @Column(name = "fechaAdquisicion")
  @JsonFormat( shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
  private Date dateAdd;

  @ManyToOne
  @JoinColumn(name = "id_categoria")
  private Category category;

  @ManyToOne
  @JoinColumn(name = "id_proveedor")
  private Supplier supplier;


}
