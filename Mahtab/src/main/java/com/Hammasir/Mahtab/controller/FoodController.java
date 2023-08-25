package com.Hammasir.Mahtab.controller;

import com.Hammasir.Mahtab.model.Food;
import com.Hammasir.Mahtab.service.FoodService;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {
    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping("/create/{id}")
    public ResponseEntity<Food> createFood(@PathVariable("id") int id, @RequestBody Food food) {
        Food createdRestaurant = foodService.createFood(id, food);
        return ResponseEntity.ok(createdRestaurant);
    }

//    @GetMapping("/readAll")
//    public List<Restaurant> getRestaurants() {
//        return restaurantService.getRestaurants();
//    }
//
//    @GetMapping("readById/{id}")
//    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable("id") int id) {
//        Restaurant restaurant = restaurantService.getRestaurantById(id);
//        if (restaurant == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(restaurant);
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable("id") int id, @RequestBody Restaurant restaurant) {
//        Restaurant updatedRestaurant = restaurantService.updateRestaurant(id, restaurant);
//        if (updatedRestaurant == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(updatedRestaurant);
//    }
//
//    @DeleteMapping("deleteAll")
//    public ResponseEntity<Void> deleteRestaurants() {
//        boolean deleted = restaurantService.deleteRestaurants();
//        if (!deleted) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.noContent().build();
//    }
//    @DeleteMapping("deleteById/{id}")
//    public ResponseEntity<Void> deleteRestaurant(@PathVariable("id") int id) {
//        boolean deleted = restaurantService.deleteRestaurant(id);
//        if (!deleted) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.noContent().build();
//    }
}
