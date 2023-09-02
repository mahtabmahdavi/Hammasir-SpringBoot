package com.Hammasir.Mahtab.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Order {
    private UUID id;
    private FoodDTO item;

    public Order(UUID id, FoodDTO item) {
        this.id = id;
        this.item = item;
    }
}
