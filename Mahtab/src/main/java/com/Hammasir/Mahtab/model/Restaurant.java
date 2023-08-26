package com.Hammasir.Mahtab.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.ArrayList;

@Getter @Setter
public class Restaurant {
    private int id;
    private String name;
    private String phoneNumber;
    private String address;
    private List<MenuDTO> menu = new ArrayList<>();

    public Restaurant(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
