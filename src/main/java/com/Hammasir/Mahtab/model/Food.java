package com.Hammasir.Mahtab.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Food {
    private int id;
    private String name;

    public Food(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
