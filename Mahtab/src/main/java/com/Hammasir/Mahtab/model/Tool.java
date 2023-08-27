package com.Hammasir.Mahtab.model;

import java.util.List;

public class Tool {
    public static Restaurant findRestaurant(int id, List<Restaurant> restaurants) {
        return restaurants.stream()
                .filter(restaurant -> restaurant.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
