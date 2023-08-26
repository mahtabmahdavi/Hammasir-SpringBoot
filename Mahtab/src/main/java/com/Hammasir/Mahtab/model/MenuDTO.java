package com.Hammasir.Mahtab.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MenuDTO {
    private String name;
    private Long price;

    public MenuDTO(String name, long price) {
        this.name = name;
        this.price = price;
    }
}
