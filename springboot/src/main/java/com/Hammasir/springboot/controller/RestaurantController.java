package com.Hammasir.springboot.controller;

import com.Hammasir.springboot.model.Restaurant;
import com.Hammasir.springboot.model.DTO.RestaurantDTO;
import com.Hammasir.springboot.service.RestaurantService;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping(value = "restaurant")
public class RestaurantController {
    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping
    public ResponseEntity<Restaurant> create(@RequestBody RestaurantDTO restaurant) {
        try {
            Restaurant createdRestaurant = restaurantService.createRestaurant(restaurant);
            if (createdRestaurant == null) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(createdRestaurant);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Restaurant>> getAll() {
        try {
            List<Restaurant> restaurants = restaurantService.getAllRestaurants();
            return ResponseEntity.ok(restaurants);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Restaurant> getById(@PathVariable("id") long id) {
        try {
            Restaurant desiredRestaurant = restaurantService.getRestaurantById(id);
            if (desiredRestaurant == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(desiredRestaurant);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<Restaurant> getByName(@RequestBody String name) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(name);
            String restaurantName = jsonNode.get("name").asText();
            Restaurant desiredRestaurant = restaurantService.getRestaurantByName(restaurantName);
            if (desiredRestaurant == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(desiredRestaurant);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping
    public ResponseEntity<Restaurant> update(@RequestBody RestaurantDTO restaurant) {
        try {
            Restaurant updatedRestaurant = restaurantService.updateRestaurant(restaurant);
            if (updatedRestaurant == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(updatedRestaurant);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping(value = "/all")
    public ResponseEntity<Void> deleteAll() {
        try {
            boolean isDeleted = restaurantService.deleteAllRestaurants();
            if (!isDeleted) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") long id) {
        try {
            boolean isDeleted = restaurantService.deleteRestaurantById(id);
            if (!isDeleted) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteByName(@RequestBody String name) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(name);
            String restaurantName = jsonNode.get("name").asText();
            boolean isDeleted = restaurantService.deleteRestaurantByName(restaurantName);
            if (!isDeleted) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
