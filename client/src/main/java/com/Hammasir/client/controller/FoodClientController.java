package com.Hammasir.client.controller;

import com.Hammasir.client.model.Food;
import com.Hammasir.client.service.FoodClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "food-client/{id}")
public class FoodClientController {

        private FoodClientService foodClientService;

        public FoodClientController(FoodClientService foodClientService) {
            this.foodClientService = foodClientService;
        }
        @PostMapping
        public ResponseEntity<Food> create(@PathVariable("id") long restaurantId, @RequestBody Food food) {
            return ResponseEntity.ok(foodClientService.createFood(restaurantId, food));
        }

        @GetMapping
        public List<Food> getAll(@PathVariable("id") long restaurantId) {
            return foodClientService.getAllFoods(restaurantId);
        }
}
