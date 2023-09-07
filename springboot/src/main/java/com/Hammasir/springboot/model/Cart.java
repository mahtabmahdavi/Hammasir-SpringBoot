package com.Hammasir.springboot.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "carts")
public class Cart {
     @Id
     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carts_id_seq")
     long id;

     @ManyToOne(targetEntity = Order.class, fetch = FetchType.LAZY)
     @JoinColumn(name = "order_id", nullable = false)
     Order order;

     @ManyToOne(targetEntity = Food.class, fetch = FetchType.LAZY)
     @JoinColumn(name = "food_id", nullable = false)
     Food food;
}
