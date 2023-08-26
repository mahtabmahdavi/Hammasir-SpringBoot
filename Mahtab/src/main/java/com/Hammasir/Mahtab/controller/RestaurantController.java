package com.Hammasir.Mahtab.controller;

import com.Hammasir.Mahtab.model.Restaurant;
import com.Hammasir.Mahtab.model.RestaurantDTO;
import com.Hammasir.Mahtab.service.RestaurantService;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("/create")
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody RestaurantDTO restaurant) {
        Restaurant createdRestaurant = restaurantService.createRestaurant(restaurant);
        if (createdRestaurant == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(createdRestaurant);
    }

    @GetMapping("/readAll")
    public List<Restaurant> readAllRestaurants() {
        return restaurantService.readAllRestaurants();
    }

    @GetMapping("readById/{id}")
    public ResponseEntity<Restaurant> readRestaurantById(@PathVariable("id") int id) {
        Restaurant restaurant = restaurantService.readRestaurantById(id);
        if (restaurant == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(restaurant);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable("id") int id, @RequestBody RestaurantDTO restaurant) {
        Restaurant updatedRestaurant = restaurantService.updateRestaurant(id, restaurant);
        if (updatedRestaurant == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedRestaurant);
    }

    @DeleteMapping("deleteAll")
    public ResponseEntity<Void> deleteAllRestaurants() {
        boolean deleted = restaurantService.deleteAllRestaurants();
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("deleteById/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable("id") int id) {
        boolean deleted = restaurantService.deleteRestaurant(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
