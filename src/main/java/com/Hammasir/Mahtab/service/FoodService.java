package com.Hammasir.Mahtab.service;

import com.Hammasir.Mahtab.model.DTO.FoodDTO;
import com.Hammasir.Mahtab.model.Restaurant;

import org.springframework.stereotype.Service;

import java.util.List;

//@Service
//public class FoodService {
//    private final List<Restaurant> restaurants = DataBase.readRestaurants( "input/restaurant.txt" );
//
//    public static FoodDTO findFood(String foodName, Restaurant restaurant) {
//        return restaurant.getMenu().stream()
//                .filter(food -> food.getName().equals(foodName))
//                .findFirst()
//                .orElse(null);
//    }
//
//    public FoodDTO createFood(int id, FoodDTO newFood) {
//        Restaurant desiredRestaurant = RestaurantService.findRestaurant(id, restaurants);
//        if (desiredRestaurant != null) {
//            FoodDTO desiredFood = findFood(newFood.getName(), desiredRestaurant);
//            if (desiredFood == null) {
//                List<FoodDTO> menu = desiredRestaurant.getMenu();
//                menu.add(new FoodDTO(newFood.getName(), newFood.getPrice()));
//                desiredRestaurant.setMenu(menu);
//                return newFood;
//            }
//        }
//        return null;
//    }
//
//    public List<FoodDTO> getAllFoods(int id) {
//        Restaurant desiredRestaurant = RestaurantService.findRestaurant(id, restaurants);
//        if (desiredRestaurant != null) {
//            return desiredRestaurant.getMenu();
//        }
//        return null;
//    }
//
//    public FoodDTO getFoodByName(int id, String foodName) {
//        Restaurant desiredRestaurant = RestaurantService.findRestaurant(id, restaurants);
//        if (desiredRestaurant != null) {
//            return findFood(foodName, desiredRestaurant);
//        }
//        return null;
//    }
//
//    public FoodDTO updateFood(int id, FoodDTO updatedFood) {
//        Restaurant desiredRestaurant = RestaurantService.findRestaurant(id, restaurants);
//        return desiredRestaurant.getMenu().stream()
//                .filter(food -> food.getName().equals(updatedFood.getName()))
//                .findFirst()
//                .map( food -> {
//                    food.setPrice(updatedFood.getPrice());
//                    return food;
//                })
//                .orElse(null);
//    }
//
//    public boolean deleteAllFoods(int id) {
//        Restaurant desiredRestaurant = RestaurantService.findRestaurant(id, restaurants);
//        if (desiredRestaurant != null) {
//            desiredRestaurant.setMenu(null);
//            return true;
//        }
//        return false;
//    }
//
//    public boolean deleteFoodByName(int id, String foodName) {
//        Restaurant desiredRestaurant = RestaurantService.findRestaurant(id, restaurants);
//        if (desiredRestaurant != null) {
//            FoodDTO desiredFood = findFood(foodName, desiredRestaurant);
//            if (desiredFood != null) {
//                List<FoodDTO> menu = desiredRestaurant.getMenu();
//                menu.remove(desiredFood);
//                desiredRestaurant.setMenu(menu);
//                return true;
//            }
//        }
//        return false;
//    }
//}
