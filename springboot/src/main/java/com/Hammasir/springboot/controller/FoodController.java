package com.Hammasir.springboot.controller;

import com.Hammasir.springboot.model.dto.FoodDTO;
import com.Hammasir.springboot.service.FoodService;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

@RestController
@RequestMapping(value = "food/{id}")
public class FoodController {
    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

//    @PostMapping
//    public ResponseEntity<List<FoodDTO>> create(@PathVariable("id") long restaurantId, @RequestBody FoodDTO food) {
//        try {
//            List<FoodDTO> menu = foodService.createFood(restaurantId, food);
//            if (!menu.isEmpty()) {
//                return ResponseEntity.ok(menu);
//            } else {
//                return ResponseEntity.notFound().build();
//            }
//        } catch (Exception e) {
//            return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    @GetMapping(value = "/all")
//    public ResponseEntity<List<FoodDTO>> getAll(@PathVariable("id") long restaurantId) {
//        try {
//            List<FoodDTO> menu = foodService.getAllFoods(restaurantId);
//            if (!menu.isEmpty()) {
//                return ResponseEntity.ok(menu);
//            } else {
//                return ResponseEntity.notFound().build();
//            }
//        } catch (Exception e) {
//            return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    @GetMapping
//    public ResponseEntity<FoodDTO> getByName(@PathVariable("id") long restaurantId, @RequestBody String food) {
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            JsonNode jsonNode = objectMapper.readTree(food);
//            String foodName = jsonNode.get("name").asText();
//            FoodDTO desiredFood = foodService.getFoodByName(restaurantId, foodName);
//            if (desiredFood != null) {
//                return ResponseEntity.ok(desiredFood);
//            } else {
//                return ResponseEntity.notFound().build();
//            }
//        } catch (Exception e) {
//            return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }

//    @PutMapping
//    public ResponseEntity<FoodDTO> update(@PathVariable("id") long restaurantId, @RequestBody FoodDTO food) {
//        try {
//            FoodDTO updatedFood = foodService.updateFood(restaurantId, food);
//            if (updatedFood != null) {
//                return ResponseEntity.ok(updatedFood);
//            } else {
//                return ResponseEntity.notFound().build();
//            }
//        } catch (Exception e) {
//            return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    @DeleteMapping(value = "/all")
//    public ResponseEntity<Void> deleteAll(@PathVariable("id") int id) {
//        try {
//            boolean isDeleted = foodService.deleteAllFoods(id);
//            if (isDeleted) {
//                return ResponseEntity.ok().build();
//            } else {
//                return ResponseEntity.notFound().build();
//            }
//        } catch (Exception e) {
//            return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    @DeleteMapping
//    public ResponseEntity<List<FoodDTO>> deleteByName(@PathVariable("id") long restaurantId, @RequestBody String food) {
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            JsonNode jsonNode = objectMapper.readTree(food);
//            String foodName = jsonNode.get("name").asText();
//            List<FoodDTO> menu = foodService.deleteFoodByName(restaurantId, foodName);
//            if (!menu.isEmpty()) {
//                return ResponseEntity.ok(menu);
//            } else {
//                return ResponseEntity.notFound().build();
//            }
//        } catch (Exception e) {
//            return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
}
