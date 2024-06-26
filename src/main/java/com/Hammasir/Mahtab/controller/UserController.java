package com.Hammasir.Mahtab.controller;

import com.Hammasir.Mahtab.model.FoodDTO;
import com.Hammasir.Mahtab.model.Order;
import com.Hammasir.Mahtab.model.OrderDTO;
import com.Hammasir.Mahtab.service.UserService;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    final private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<FoodDTO>> get(@RequestBody OrderDTO order) {
        try {
            List<FoodDTO> orders = userService.getOrders(order);
            if (orders != null) {
                return ResponseEntity.ok(orders);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
