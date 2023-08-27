package com.Hammasir.Mahtab.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FoodDTO {
    private String name;
    private Long price;

    public FoodDTO(String name, long price) {
        this.name = name;
        this.price = price;
    }
}
