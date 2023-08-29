package com.Hammasir.Mahtab.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private int id;
    private FoodDTO item;

    public Order(int id, FoodDTO item) {
        this.id = id;
        this.item = item;
    }
}
