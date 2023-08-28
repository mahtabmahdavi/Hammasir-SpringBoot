package com.Hammasir.Mahtab.controller;

import com.Hammasir.Mahtab.model.FoodDTO;
import com.Hammasir.Mahtab.model.OrderDTO;
import com.Hammasir.Mahtab.service.UserService;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    final private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/userName={userName}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<List<FoodDTO>> get(@PathVariable("userName") String userName, @RequestBody OrderDTO order) {
        List<FoodDTO> orders = userService.getOrders( userName, order );
        if (orders != null) {
            return ResponseEntity.ok( orders );
        }
        return ResponseEntity.notFound().build();
    }
}
