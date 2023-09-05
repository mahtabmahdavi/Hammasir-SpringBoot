package com.Hammasir.Mahtab.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "menus")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menus_id_seq")
    long id;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "food_id", nullable = false)
    Food food;

    @Column(name = "price", nullable = false)
    long price;
}
