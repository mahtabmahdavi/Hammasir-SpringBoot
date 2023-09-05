package com.Hammasir.Mahtab.model;

import jakarta.persistence.*;

@Entity
@Table(name = "menu")
public class Menu {
    @EmbeddedId
    MenuKey id;

    @ManyToOne
    @MapsId("restaurantId")
    @JoinColumn(name = "restaurant_id")
    Restaurant restaurant;

    @ManyToOne
    @MapsId("foodId")
    @JoinColumn(name = "food_id")
    Food food;

    long price;
}
