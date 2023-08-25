package com.Hammasir.Mahtab.controller;

import com.Hammasir.Mahtab.model.Restaurant;
import com.Hammasir.Mahtab.service.RestaurantService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public List<Restaurant> getRestaurants() {
        return restaurantService.getRestaurants();
    }

    @GetMapping("/id={id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable("id") int id) {
        Restaurant restaurant = restaurantService.getRestaurantById(id);
        if (restaurant == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(restaurant);
    }

    @PostMapping
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
        Restaurant createdRestaurant = restaurantService.createRestaurant(restaurant);
        return ResponseEntity.ok(createdRestaurant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable("id") int id, @RequestBody Restaurant restaurant) {
        Restaurant updatedRestaurant = restaurantService.updateRestaurant(id, restaurant);
        if (updatedRestaurant == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedRestaurant);
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable("id") int id) {
        boolean deleted = restaurantService.deleteRestaurant(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
