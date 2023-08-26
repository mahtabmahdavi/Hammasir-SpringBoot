package com.Hammasir.Mahtab.service;

import com.Hammasir.Mahtab.model.Restaurant;
import com.Hammasir.Mahtab.model.RestaurantDTO;
import static com.Hammasir.Mahtab.repository.DataBase.readRestaurants;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    private final List<Restaurant> restaurantList = readRestaurants("input/restaurant.txt");

    public Restaurant createRestaurant(RestaurantDTO restaurant) {
        Restaurant createdRestaurant = new Restaurant(restaurant.getId(), restaurant.getName());
        boolean isCreate = restaurantList.stream()
                .noneMatch(r -> r.getId() == createdRestaurant.getId());
        if (isCreate) {
            restaurantList.add(createdRestaurant);
            return createdRestaurant;
        } else {
            return null;
        }
    }

    public List<Restaurant> readAllRestaurants() {
        return restaurantList;
    }

    public Restaurant readRestaurantById(int id) {
        return restaurantList.stream()
                .filter(restaurant -> restaurant.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Restaurant updateRestaurant(int id, RestaurantDTO restaurant) {
        Restaurant updatedRestaurant = new Restaurant(restaurant.getId(), restaurant.getName());
        return restaurantList.stream()
                .filter(r -> r.getId() == id)
                .findFirst()
                .map(r -> {
                    r.setId(updatedRestaurant.getId());
                    r.setName(updatedRestaurant.getName());
                    return r;
                })
                .orElse(null);
    }

    public boolean deleteAllRestaurants() {
        return restaurantList.removeAll(restaurantList);
    }

    public boolean deleteRestaurantById(int id) {
        Restaurant deleteRestaurant = restaurantList.stream()
                .filter(restaurant -> restaurant.getId() == id)
                .findFirst()
                .orElse(null);
        if (deleteRestaurant != null) {
            restaurantList.remove(deleteRestaurant);
            return true;
        } else {
            return false;
        }
    }
}
