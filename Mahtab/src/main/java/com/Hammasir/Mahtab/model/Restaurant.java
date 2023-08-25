package com.Hammasir.Mahtab.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.HashMap;

@Getter @Setter
public class Restaurant {
    private int id;
    private String name;
    // private Map<Long, Food> menu = new HashMap<>();

    public Restaurant(int id, String name) {
        this.id = id;
        this.name = name;
    }

//    public void addFood(long price, Food food) {
//        if (!menu.containsValue(food)) {
//            menu.put(price, food);
//        }
//    }
}
