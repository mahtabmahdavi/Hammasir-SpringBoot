package com.Hammasir.Mahtab.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Food {
    private String name;

    public Food(String name) {
        this.name = name;
    }
}
