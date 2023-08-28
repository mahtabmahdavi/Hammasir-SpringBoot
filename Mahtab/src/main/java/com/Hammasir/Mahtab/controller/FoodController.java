package com.Hammasir.Mahtab.controller;

import com.Hammasir.Mahtab.model.FoodDTO;
import com.Hammasir.Mahtab.service.FoodService;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RestController
@RequestMapping("restaurant/restaurantId={id}/food")
public class FoodController {
    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<FoodDTO> create(@PathVariable("id") int id, @RequestBody FoodDTO food) {
        FoodDTO createdFood = foodService.createFood(id, food);
        if (createdFood != null) {
            return ResponseEntity.ok(food);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping
    public ResponseEntity<List<FoodDTO>> getAll(@PathVariable("id") int id) {
        List<FoodDTO> menu = foodService.getAllFoods(id);
        if (menu != null) {
            return ResponseEntity.ok(menu);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{name}")
    public ResponseEntity<FoodDTO> getByName(@PathVariable("id") int id, @PathVariable("name") String name) {
        FoodDTO desiredFood = foodService.getFoodByName(id, name);
        if (desiredFood != null) {
            return ResponseEntity.ok(desiredFood);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{name}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<FoodDTO> update(@PathVariable("id") int id, @PathVariable("name") String name, @RequestBody FoodDTO food) {
        FoodDTO updatedFood = foodService.updateFood(id, name, food);
        if (updatedFood != null) {
            return ResponseEntity.ok(updatedFood);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteAll(@PathVariable("id") int id) {
        boolean isDeleted = foodService.deleteAllFoods(id);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{name}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteByName(@PathVariable("id") int id, @PathVariable("name") String name) {
        boolean isDeleted = foodService.deleteFoodByName(id, name);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
