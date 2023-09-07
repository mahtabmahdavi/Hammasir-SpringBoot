package com.Hammasir.springboot.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "menus")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menus_id_seq")
    long id;

    @ManyToOne(targetEntity = Restaurant.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    Restaurant restaurant;

    @ManyToOne(targetEntity = Food.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id", nullable = false)
    Food firstFood;

    @Column(name = "price", nullable = false)
    long price;
}
