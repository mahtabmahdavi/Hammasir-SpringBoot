package com.Hammasir.springboot.repository;

import com.Hammasir.springboot.model.entity.Food;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    Food findByName(String name);
}
