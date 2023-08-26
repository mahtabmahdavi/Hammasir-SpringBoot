package com.Hammasir.Mahtab.controller;

import com.Hammasir.Mahtab.model.Food;
import com.Hammasir.Mahtab.model.MenuDTO;
import com.Hammasir.Mahtab.model.Restaurant;
import com.Hammasir.Mahtab.model.RestaurantDTO;
import com.Hammasir.Mahtab.service.FoodService;
import com.Hammasir.Mahtab.service.RestaurantService;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("restaurant/food")
public class FoodController {
    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

//    @PostMapping("/create/restaurantId={id}")
//    public ResponseEntity<Restaurant> createFood(@RequestBody RestaurantDTO restaurant) {
//        Restaurant createdRestaurant = restaurantService.createRestaurant(restaurant);
//        if (createdRestaurant == null) {
//            return ResponseEntity.badRequest().build();
//        }
//        return ResponseEntity.ok(createdRestaurant);
//    }

    @GetMapping("/readAl/restaurantId={id}")
    public ResponseEntity<List<MenuDTO>> readAllFoods(@PathVariable("id") int id) {
        List<MenuDTO> menu = foodService.readAllFoods(id);
        if (menu != null) {
            return ResponseEntity.ok(menu);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

//    @GetMapping("readById/{id}")
//    public ResponseEntity<Restaurant> readRestaurantById(@PathVariable("id") int id) {
//        Restaurant restaurant = restaurantService.readRestaurantById(id);
//        if (restaurant == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(restaurant);
//    }
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
//    @DeleteMapping("deleteAll")
//    public ResponseEntity<Void> deleteAllRestaurants() {
//        boolean deleted = restaurantService.deleteAllRestaurants();
//        if (!deleted) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok().build();
//    }
//
//    @DeleteMapping("deleteById/{id}")
//    public ResponseEntity<Void> deleteRestaurant(@PathVariable("id") int id) {
//        boolean deleted = restaurantService.deleteRestaurant(id);
//        if (!deleted) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok().build();
//    }
}