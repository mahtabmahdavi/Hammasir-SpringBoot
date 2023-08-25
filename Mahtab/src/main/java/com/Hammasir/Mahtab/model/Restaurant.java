package com.Hammasir.Mahtab.model;

import static com.Hammasir.Mahtab.repository.DataBase.readFoods;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.HashMap;

@Getter @Setter
public class Restaurant {
    private int id;
    private String name;
    private Map<Long, Food> menu = new HashMap<>();

    public Restaurant(int id, String name) {
        this.id = id;
        this.name = name;
        this.addFood("input/{name}-food.txt");
    }

    public void addFood(String filePath) {
        menu = readFoods(filePath);
    }
}
