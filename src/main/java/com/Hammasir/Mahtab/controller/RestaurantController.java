package com.Hammasir.Mahtab.controller;

//import com.Hammasir.Mahtab.model.Restaurant;
//import com.Hammasir.Mahtab.model.DTO.RestaurantDTO;
//import com.Hammasir.Mahtab.service.RestaurantService;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

//@RestController
//@RequestMapping(value = "restaurant")
//public class RestaurantController {
//    private final RestaurantService restaurantService;
//
//    public RestaurantController(RestaurantService restaurantService) {
//        this.restaurantService = restaurantService;
//    }
//
//    @PostMapping
//    public ResponseEntity<Restaurant> create(@RequestBody RestaurantDTO restaurant) {
//        try {
//            Restaurant createdRestaurant = restaurantService.createRestaurant(restaurant);
//            if (createdRestaurant == null) {
//                return ResponseEntity.badRequest().build();
//            }
//            return ResponseEntity.ok(createdRestaurant);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//    @GetMapping(value = "/all")
//    public ResponseEntity<List<Restaurant>> getAll() {
//        try {
//            List<Restaurant> restaurants = restaurantService.getAllRestaurants();
//            return ResponseEntity.ok(restaurants);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    @GetMapping(value = "/{id}")
//    public ResponseEntity<Restaurant> getById(@PathVariable("id") int id) {
//        try {
//            Restaurant desiredRestaurant = restaurantService.getRestaurantById(id);
//            if (desiredRestaurant == null) {
//                return ResponseEntity.notFound().build();
//            }
//            return ResponseEntity.ok(desiredRestaurant);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    @PutMapping(value = "/{id}")
//    public ResponseEntity<Restaurant> update(@PathVariable("id") int id, @RequestBody RestaurantDTO restaurant) {
//        try {
//            Restaurant updatedRestaurant = restaurantService.updateRestaurant(id, restaurant);
//            if (updatedRestaurant == null) {
//                return ResponseEntity.notFound().build();
//            }
//            return ResponseEntity.ok(updatedRestaurant);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    @DeleteMapping(value = "/all")
//    public ResponseEntity<Void> deleteAll() {
//        try {
//            boolean isDeleted = restaurantService.deleteAllRestaurants();
//            if (!isDeleted) {
//                return ResponseEntity.notFound().build();
//            }
//            return ResponseEntity.ok().build();
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity<Void> deleteById(@PathVariable("id") int id) {
//        try {
//            boolean isDeleted = restaurantService.deleteRestaurantById(id);
//            if (!isDeleted) {
//                return ResponseEntity.notFound().build();
//            }
//            return ResponseEntity.ok().build();
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//}
