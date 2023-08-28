package com.Hammasir.Mahtab.model;

import java.util.List;
import java.util.ArrayList;

public class Tool {
    public static Restaurant findRestaurant(int id, List<Restaurant> restaurants) {
        return restaurants.stream()
                .filter(restaurant -> restaurant.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public static FoodDTO findFood(String foodName, Restaurant restaurant) {
        return restaurant.getMenu().stream()
                .filter(food -> food.getName().equals(foodName))
                .findFirst()
                .orElse(null);
    }

    public static User findUser(String userName, List<User> users) {
        return users.stream()
                .filter(user -> user.getUsername().equals(userName))
                .findFirst()
                .orElse(null);
    }

    public static List<FoodDTO> helpToMakeOrder(List<Order> orders) {
        List<FoodDTO> items = new ArrayList<>();
        for (Order order : orders) {
            FoodDTO food = order.getItem();
            items.add( food );
        }
        return items;
    }
}
