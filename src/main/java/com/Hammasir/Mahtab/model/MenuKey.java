package com.Hammasir.Mahtab.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
class MenuKey implements Serializable {

    @Column(name = "restaurant_id")
    Long restaurantId;

    @Column(name = "food_id")
    Long foodId;
}
