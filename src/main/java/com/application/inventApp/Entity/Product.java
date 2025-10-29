package com.application.inventApp.Entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "producto")
public class Product extends BaseEntity {

  @Column(name = "nombre", unique = true, nullable = false)
  private String name;
  @Column(name = "descripcion", length = 400, nullable = false)
  private String description;
  @Column(name = "precio", nullable = false, precision = 10, scale = 2)
  private BigDecimal price;
  @Column(name = "stock", nullable = false, columnDefinition = "int default 0")
  private int stock;
  @Column(name = "fechaAdquisicion", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
  private Date dateAdd;

  @ManyToOne
  @JoinColumn(name = "id_categoria", nullable = false)
  private Category category;

  @ManyToOne
  @JsonIgnore
  @JoinColumn(name = "id_proveedor", nullable = false)
  private Supplier supplier;

  @ManyToMany(mappedBy = "products")
  @JsonIgnore
  private List<Sale> sales = new ArrayList<>();

}
