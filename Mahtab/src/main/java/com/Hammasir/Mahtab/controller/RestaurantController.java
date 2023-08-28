package com.Hammasir.Mahtab.controller;

import com.Hammasir.Mahtab.model.Restaurant;
import com.Hammasir.Mahtab.model.RestaurantDTO;
import com.Hammasir.Mahtab.service.RestaurantService;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Restaurant> create(@RequestBody RestaurantDTO restaurant) {
        Restaurant createdRestaurant = restaurantService.createRestaurant(restaurant);
        if (createdRestaurant == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(createdRestaurant);
    }

    @GetMapping
    public ResponseEntity<List<Restaurant>> getAll() {
        return ResponseEntity.ok(restaurantService.getAllRestaurants());
    }

    @GetMapping("/id={id}")
    public ResponseEntity<Restaurant> getById(@PathVariable("id") int id) {
        Restaurant desiredRestaurant = restaurantService.getRestaurantById(id);
        if (desiredRestaurant == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(desiredRestaurant);
    }

    @PutMapping("/id={id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Restaurant> update(@PathVariable("id") int id, @RequestBody RestaurantDTO restaurant) {
        Restaurant updatedRestaurant = restaurantService.updateRestaurant(id, restaurant);
        if (updatedRestaurant == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedRestaurant);
    }

    @DeleteMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteAll() {
        boolean isDeleted = restaurantService.deleteAllRestaurants();
        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/id={id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteById(@PathVariable("id") int id) {
        boolean isDeleted = restaurantService.deleteRestaurantById(id);
        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
