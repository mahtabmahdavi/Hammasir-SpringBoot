package com.Hammasir.client.controller;

import com.Hammasir.client.model.Restaurant;
import com.Hammasir.client.service.RestaurantClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "restaurant-client")
public class RestaurantClientController {

    private RestaurantClientService restaurantClientService;

    public RestaurantClientController(RestaurantClientService restaurantClientService) {
        this.restaurantClientService = restaurantClientService;
    }
    @PostMapping
    public ResponseEntity<Restaurant> create(@RequestBody Restaurant restaurant) {
        return ResponseEntity.ok(restaurantClientService.createRestaurant(restaurant));
    }

    @GetMapping
    public List<Restaurant> getAll() {
        return restaurantClientService.getAllRestaurants();
    }
}
