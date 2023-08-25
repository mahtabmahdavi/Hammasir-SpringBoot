package com.Hammasir.Mahtab.service;

import com.Hammasir.Mahtab.model.Restaurant;
import static com.Hammasir.Mahtab.repository.DataBase.readRestaurants;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RestaurantService {
    private final List<Restaurant> restaurantList = readRestaurants("restaurant.txt");

    public List<Restaurant> getRestaurants() {
        return restaurantList;
    }

    public Restaurant getRestaurantById(int id) {
        return restaurantList.stream()
                .filter(restaurant -> restaurant.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Restaurant createRestaurant(Restaurant createdRestaurant) {
        boolean isCreate = restaurantList.stream()
                .noneMatch(restaurant -> restaurant.equals(createdRestaurant));

        if (isCreate) {
            restaurantList.add(createdRestaurant);
        }
        return createdRestaurant;
    }

    public Restaurant updateRestaurant(int id, Restaurant updatedRestaurant) {
        return restaurantList.stream()
                .filter(restaurant -> restaurant.getId() == id)
                .findFirst()
                .map(restaurant -> {
                    restaurant.setId(updatedRestaurant.getId());
                    restaurant.setName(updatedRestaurant.getName());
                    return restaurant;
                })
                .orElse(null);
    }

    public boolean deleteRestaurant(int id) {
        return restaurantList.stream()
                .anyMatch(restaurant -> {
                    if (restaurant.getId() == id) {
                        restaurantList.remove(restaurant);
                        return true;
                    }
                    return false;
                });
    }
}