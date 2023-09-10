package com.Hammasir.springboot.repository;

import com.Hammasir.springboot.model.entity.Restaurant;
import com.Hammasir.springboot.model.entity.RestaurantFoodMapping;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantFoodMappingRepository  extends JpaRepository<RestaurantFoodMapping, Long> {
    @Query("SELECT rfm FROM RestaurantFoodMapping rfm WHERE rfm.restaurant = :restaurant ORDER BY rfm.price")
    List<RestaurantFoodMapping> findByRestaurant(@Param("restaurant") Restaurant restaurant);

//    @Query("select rfm from RestaurantFoodMapping rfm where rfm.restaurant = :restaurant and rfm.food.name = :foodName")
//    Optional<RestaurantFoodMapping> findByRestaurantAndFoodName(@Param("restaurant") Restaurant restaurant,
//                                                                @Param("foodName")String foodName);
}
