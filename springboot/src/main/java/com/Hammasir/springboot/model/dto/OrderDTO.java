package com.Hammasir.springboot.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {
    private int restaurantId;
    private String username;
    private String foodName;
}
