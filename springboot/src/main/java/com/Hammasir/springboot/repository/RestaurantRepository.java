package com.Hammasir.springboot.repository;

import com.Hammasir.springboot.model.entity.Restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Restaurant findById(long id);
    Restaurant findByName(String name);
}
