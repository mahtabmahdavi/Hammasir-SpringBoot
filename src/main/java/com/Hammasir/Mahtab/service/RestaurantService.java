package com.Hammasir.Mahtab.service;

import com.Hammasir.Mahtab.model.Restaurant;
import com.Hammasir.Mahtab.model.RestaurantDTO;
import com.Hammasir.Mahtab.repository.DataBase;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    private final List<Restaurant> restaurants = DataBase.readRestaurants("input/restaurant.txt");

    public static Restaurant findRestaurant(int id, List<Restaurant> restaurants) {
        return restaurants.stream()
                .filter(restaurant -> restaurant.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Restaurant createRestaurant(RestaurantDTO restaurant) {
        Restaurant createdRestaurant = new Restaurant(restaurant.getId(), restaurant.getName());
        boolean isCreated = restaurants.stream()
                .noneMatch(r -> r.getId() == createdRestaurant.getId());
        if (isCreated) {
            restaurants.add(createdRestaurant);
            return createdRestaurant;
        }
        return null;
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurants;
    }

    public Restaurant getRestaurantById(int id) {
        return findRestaurant(id, restaurants);
    }

    public Restaurant updateRestaurant(int id, RestaurantDTO restaurant) {
        Restaurant updatedRestaurant = new Restaurant(restaurant.getId(), restaurant.getName());
        return restaurants.stream()
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
        return restaurants.removeAll(restaurants);
    }

    public boolean deleteRestaurantById(int id) {
        Restaurant deletedRestaurant = findRestaurant(id, restaurants);
        if (deletedRestaurant != null) {
            restaurants.remove(deletedRestaurant);
            return true;
        }
        return false;
    }
}
