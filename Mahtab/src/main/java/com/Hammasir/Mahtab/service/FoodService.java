package com.Hammasir.Mahtab.service;

import com.Hammasir.Mahtab.model.Food;
import com.Hammasir.Mahtab.model.Restaurant;
import static com.Hammasir.Mahtab.repository.DataBase.readRestaurants;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

@Service
public class FoodService {
    private final List<Restaurant> restaurantList = readRestaurants("input/restaurant.txt");

//    public static Map<String, Long> makeCustomeMap (Restaurant restaurant) {
//        Map<String, Long> menu = new HashMap<>();
//        restaurant.getMenu().forEach((key, value) -> menu.put( key.getName(), value));
//        return menu;
//    }

//    public Map<String, Long> createFood(int id, Food food, Long price) {
//        Restaurant restaurant = restaurantList.stream()
//                .filter(r -> r.getId() == id)
//                .findFirst()
//                .orElse(null);
//        if (restaurant != null) {
//            restaurant.addFood(food, price);
//            Map<String, Long> menu = new HashMap<>();
//            restaurant.getMenu().forEach((key, value) -> menu.put( key.getName(), value));
//            return menu;
//        } else {
//            return Collections.emptyMap();
//        }
//    }
//    public Map<String, Long> readAllFoods(int id) {
//        Restaurant restaurant = restaurantList.stream()
//                .filter(r -> r.getId() == id)
//                .findFirst()
//                .orElse(null);
//        if (restaurant != null) {
//            Map<String, Long> menu = new HashMap<>();
//            restaurant.getMenu().forEach((key, value) -> menu.put( key.getName(), value));
//            return menu;
//        } else {
//            return Collections.emptyMap();
//        }
//    }
//
//    public Map<String, Long> readFoodById(int restaurantId, int foodId) {
//        Restaurant restaurant = restaurantList.stream()
//                .filter(r -> r.getId() == restaurantId)
//                .findFirst()
//                .orElse(null);
//        if (restaurant != null) {
//            Map<String, Long> food = new HashMap<>();
//            restaurant.getMenu().forEach((key, value) -> {
//                if (key.getId() == foodId) {
//                    food.put( key.getName(), value );
//                }
//            });
//            return food;
//        } else {
//            return Collections.emptyMap();
//        }
//    }

//    public Restaurant updateRestaurant(int id, Restaurant updatedRestaurant) {
//        return restaurantList.stream()
//                .filter(restaurant -> restaurant.getId() == id)
//                .findFirst()
//                .map(restaurant -> {
//                    restaurant.setId(updatedRestaurant.getId());
//                    restaurant.setName(updatedRestaurant.getName());
//                    return restaurant;
//                })
//                .orElse(null);
//    }
//
//    public boolean deleteRestaurants() {
//        return restaurantList.removeAll(restaurantList);
//    }
//
//    public boolean deleteRestaurant(int id) {
//        return restaurantList.stream()
//                .anyMatch(restaurant -> {
//                    if (restaurant.getId() == id) {
//                        restaurantList.remove(restaurant);
//                        return true;
//                    }
//                    return false;
//                });
//    }
}

