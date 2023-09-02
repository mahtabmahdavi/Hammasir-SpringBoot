package com.Hammasir.Mahtab.controller;

import com.Hammasir.Mahtab.model.FoodDTO;
import com.Hammasir.Mahtab.service.FoodService;

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

    @PostMapping
    public ResponseEntity<FoodDTO> create(@PathVariable("id") int id, @RequestBody FoodDTO food) {
        try {
            FoodDTO createdFood = foodService.createFood(id, food);
            if (createdFood != null) {
                return ResponseEntity.ok(food);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<FoodDTO>> getAll(@PathVariable("id") int id) {
        try {
            List<FoodDTO> menu = foodService.getAllFoods(id);
            if (menu != null) {
                return ResponseEntity.ok(menu);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<FoodDTO> getByName(@PathVariable("id") int id, @RequestBody String food) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(food);
            String foodName = jsonNode.get("name").asText();
            FoodDTO desiredFood = foodService.getFoodByName(id, foodName);
            if (desiredFood != null) {
                return ResponseEntity.ok(desiredFood);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping
    public ResponseEntity<FoodDTO> update(@PathVariable("id") int id, @RequestBody FoodDTO food) {
        try {
            FoodDTO updatedFood = foodService.updateFood(id, food);
            if (updatedFood != null) {
                return ResponseEntity.ok(updatedFood);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping(value = "/all")
    public ResponseEntity<Void> deleteAll(@PathVariable("id") int id) {
        try {
            boolean isDeleted = foodService.deleteAllFoods(id);
            if (isDeleted) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteByName(@PathVariable("id") int id, @RequestBody String food) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(food);
            String foodName = jsonNode.get("name").asText();
            boolean isDeleted = foodService.deleteFoodByName(id, foodName);
            if (isDeleted) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
