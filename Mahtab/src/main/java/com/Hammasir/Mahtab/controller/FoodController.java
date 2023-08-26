package com.Hammasir.Mahtab.controller;

import com.Hammasir.Mahtab.model.Food;
import com.Hammasir.Mahtab.service.FoodService;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("restaurant/food")
public class FoodController {
    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

//    @PostMapping("/create/{restaurantId}")
//    public ResponseEntity<Map<String, Long>> createFood(@PathVariable("restaurantId") int id, @RequestBody Food food) {
//        Map<String, Long> createdFood = foodService.createFood(id, food, price);
//        return ResponseEntity.ok(createdfood);
//    }
//
//    @GetMapping("/readAll/{restaurantId}")
//    public Map<String, Long> readAllFoods(@PathVariable("restaurantId") int id) {
//        return foodService.readAllFoods(id);
//    }
//
//    @GetMapping("readById/{restaurantId}/{foodId}")
//    public ResponseEntity<Map<String, Long>> readFoodById(@PathVariable("restaurantId") int restaurantId, @PathVariable("foodId") int foodId) {
//        Map<String, Long> desiredFood = foodService.readFoodById(restaurantId, foodId);
//        if (desiredFood == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(desiredFood);
//    }

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
