package com.Hammasir.springboot.service;

import com.Hammasir.springboot.model.entity.Food;
import com.Hammasir.springboot.model.dto.FoodDTO;
import com.Hammasir.springboot.model.entity.Restaurant;
import com.Hammasir.springboot.model.entity.RestaurantFoodMapping;
import com.Hammasir.springboot.repository.FoodRepository;
import com.Hammasir.springboot.repository.RestaurantRepository;
import com.Hammasir.springboot.repository.RestaurantFoodMappingRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodService {
    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;
    private final RestaurantFoodMappingRepository restaurantFoodMappingRepository;

    public FoodService(FoodRepository foodRepository, RestaurantRepository restaurantRepository,
                       RestaurantFoodMappingRepository restaurantFoodMappingRepository) {
        this.foodRepository = foodRepository;
        this.restaurantRepository = restaurantRepository;
        this.restaurantFoodMappingRepository = restaurantFoodMappingRepository;
    }

    public FoodDTO convertFoodItemToFoodDTO(RestaurantFoodMapping foodItem) {
        return new FoodDTO(foodItem.getFood().getName(), foodItem.getPrice());
    }
    public List<FoodDTO> convertMenuToFoodDTO(List<RestaurantFoodMapping> menu) {
        return menu.stream()
                .map(item -> new FoodDTO(item.getFood().getName(), item.getPrice()))
                .collect(Collectors.toList());
    }

    public List<FoodDTO> createFood(long restaurantId, FoodDTO createdItem) {
        try {
            Restaurant desiredRestaurant = restaurantRepository.findById(restaurantId);
            Food desiredFood = foodRepository.findByName(createdItem.getName());
            RestaurantFoodMapping desiredItem = new RestaurantFoodMapping();
            desiredItem.setRestaurant(desiredRestaurant);
            desiredItem.setPrice(createdItem.getPrice());
            if (desiredFood != null) {
                desiredItem.setFood(desiredFood);
            } else {
                Food newFood = new Food();
                newFood.setName(createdItem.getName());
                desiredItem.setFood(newFood);
                foodRepository.save(newFood);
            }
            restaurantFoodMappingRepository.save(desiredItem);
            return convertMenuToFoodDTO(desiredRestaurant.getMenu());
        } catch (Exception e) {
            throw new IllegalArgumentException("Restaurant NOT found");
        }
    }

    public List<FoodDTO> getAllFoods(long restaurantId) {
        List<RestaurantFoodMapping> menu = restaurantFoodMappingRepository.findByRestaurant(
                Restaurant.builder().id(restaurantId).build());
        return convertMenuToFoodDTO(menu);
    }

    public FoodDTO getFoodByName(long restaurantId, String foodName) {
        RestaurantFoodMapping desiredItem = restaurantFoodMappingRepository.findByRestaurantAndFoodName(
                Restaurant.builder().id(restaurantId).build(), foodName)
                .orElseThrow(() -> new IllegalArgumentException("Restaurant Food Mapping NOT found"));
        return convertFoodItemToFoodDTO(desiredItem);
    }

    public FoodDTO updateFood(long restaurantId, FoodDTO updatedItem) {
        RestaurantFoodMapping desiredItem = restaurantFoodMappingRepository.findByRestaurantAndFoodName(
                        Restaurant.builder().id(restaurantId).build(), updatedItem.getName())
                .orElseThrow(() -> new IllegalArgumentException("Restaurant Food Mapping NOT found"));
        desiredItem.setPrice(updatedItem.getPrice());
        return convertFoodItemToFoodDTO(restaurantFoodMappingRepository.save(desiredItem));
    }

    public boolean deleteAllFoods(long restaurantId) {
        List<RestaurantFoodMapping> menu = restaurantFoodMappingRepository.findByRestaurant(
                Restaurant.builder().id(restaurantId).build());
        restaurantFoodMappingRepository.deleteAll(menu);
        return menu.isEmpty();
    }

    public List<FoodDTO> deleteFoodByName(long restaurantId, String foodName) {
        RestaurantFoodMapping desiredItem = restaurantFoodMappingRepository.findByRestaurantAndFoodName(
                        Restaurant.builder().id(restaurantId).build(), foodName)
                .orElseThrow(() -> new IllegalArgumentException("Restaurant Food Mapping NOT found"));
        Restaurant desiredRestaurant = desiredItem.getRestaurant();
        List<RestaurantFoodMapping> menu = desiredRestaurant.getMenu();
        restaurantFoodMappingRepository.delete(desiredItem);
        return convertMenuToFoodDTO(menu);
    }
}
