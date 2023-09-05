package com.Hammasir.Mahtab.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "carts")
public class Cart {
     @Id
     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carts_id_seq")
     long id;

     @ManyToOne
     @JoinColumn(name = "order_id", nullable = false)
     Order order;

     @ManyToOne
     @JoinColumn(name = "food_id", nullable = false)
     Food food;
}
