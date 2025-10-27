package com.application.inventApp.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Entity(name = "proveedor")
public class Supplier extends BaseEntity {
  @Column(name = "nombre", nullable = false, length = 100)
  private String name;
  @Column(name = "contacto", nullable = false, length = 100)
  private String contact;
  @Column(name = "correo", nullable = false, length = 100)
  private String email;
  @Column(name = "direccion", nullable = false, length = 150)
  private String addres;

  @OneToMany(mappedBy = "supplier", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, orphanRemoval = true)
  private List<Product> products = new ArrayList<>();

  @OneToMany(mappedBy = "supplier", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, orphanRemoval = true)
  @JsonIgnore
  private List<Order> orders = new ArrayList<>();

  @ManyToOne
  @JoinColumn(name = "id_usuario")
  private User user;

}
