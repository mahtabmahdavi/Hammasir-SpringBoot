package com.Hammasir.springboot.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "restaurant_food_mapping")
public class RestaurantFoodMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurant_food_mapping_id")
    @SequenceGenerator(name = "restaurant_food_mapping_id", sequenceName = "restaurant_food_mapping_id_seq", allocationSize = 1)
    private long id;

    @ManyToOne(targetEntity = Restaurant.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    Restaurant restaurant;

    @ManyToOne(targetEntity = Food.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id", nullable = false)
    Food food;

    @Column(name = "price", nullable = false)
    long price;
}
