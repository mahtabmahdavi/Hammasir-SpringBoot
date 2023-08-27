package com.Hammasir.Mahtab.controller;

import com.Hammasir.Mahtab.model.FoodDTO;
import com.Hammasir.Mahtab.service.FoodService;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("restaurant/food/{id}")
public class FoodController {
    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping
    public ResponseEntity<FoodDTO> create(@PathVariable("id") int id, @RequestBody Food food) {
        FoodDTO createdFood = foodService.createFood(id, food);
        if (isCreate) {
            return ResponseEntity.ok(food);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<FoodDTO>> readAll(@PathVariable("id") int id) {
        List<FoodDTO> menu = foodService.readAllFoods(id);
        if (menu != null) {
            return ResponseEntity.ok(menu);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{name}")
    public ResponseEntity<FoodDTO> readByName(@PathVariable("id") int id, @PathVariable("name") String name) {
        FoodDTO desiredFood = foodService.readFoodByName(id, name);
        if (desiredFood != null) {
            return ResponseEntity.ok(desiredFood);
        }
        return ResponseEntity.notFound().build();
    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable("id") int id, @RequestBody RestaurantDTO restaurant) {
//        Restaurant updatedRestaurant = restaurantService.updateRestaurant(id, restaurant);
//        if (updatedRestaurant == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(updatedRestaurant);
//    }
//
    @DeleteMapping
    public ResponseEntity<Void> deleteAll(@PathVariable("id") int id) {
        boolean isDeleted = foodService.deleteAllFoods(id);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteByName(@PathVariable("id") int id, @PathVariable("name") String name) {
        boolean isDeleted = foodService.deleteFoodByName(id, name);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}