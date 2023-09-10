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
import java.util.Optional;
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

//    public List<FoodDTO> createFood(long restaurantId, FoodDTO createdItem) throws IllegalArgumentException {
//        Restaurant desiredRestaurant = restaurantRepository.findById(restaurantId)
//                .orElseThrow(() -> new IllegalArgumentException("Restaurant NOT found"));
//        if (desiredRestaurant != null) {
//            Food desiredFood = foodRepository.findByName(createdItem.getName());
//            RestaurantFoodMapping desiredItem = new RestaurantFoodMapping();
//            desiredItem.setRestaurant(desiredRestaurant);
//            desiredItem.setPrice(createdItem.getPrice());
//            if (desiredFood != null) {
//                desiredItem.setFood(desiredFood);
//                restaurantFoodMappingRepository.save(desiredItem);
//            } else {
//                Food newFood = new Food();
//                newFood.setName(createdItem.getName());
//                newFood.setIncluding(List.of(desiredItem));
//                desiredItem.setFood(newFood);
//                foodRepository.save(newFood);
//                restaurantFoodMappingRepository.save(desiredItem);
//            }
//            return getAllFoods(restaurantId);
//        }
//        return null;
//    }

//    public List<FoodDTO> getAllFoods(long restaurantId) {
//        Restaurant desiredRestaurant = new Restaurant();
//        desiredRestaurant.setId(restaurantId);
//        List<RestaurantFoodMapping> items = restaurantFoodMappingRepository.findByRestaurant(desiredRestaurant);
//        return items.stream()
//                .map(item -> new FoodDTO(item.getFood().getName(), item.getPrice()))
//                .collect(Collectors.toList());
//    }
//
//    public FoodDTO getFoodByName(long restaurantId, String foodName) {
//        Restaurant desiredRestaurant = new Restaurant();
//        desiredRestaurant.setId(restaurantId);
//        List<RestaurantFoodMapping> items = restaurantFoodMappingRepository.findByRestaurant(desiredRestaurant);
//        return items.stream()
//                .filter(item -> item.getFood().getName().equals(foodName))
//                .map(item -> new FoodDTO(item.getFood().getName(), item.getPrice()))
//                .findFirst()
//                .orElse(null);
//    }

//    public FoodDTO updateFood(long restaurantId, FoodDTO updatedItem) {
//        RestaurantFoodMapping restaurantFoodMapping =
//                restaurantFoodMappingRepository.findByRestaurantAndFoodName(
//                        Restaurant.builder().id(restaurantId).build(),
//                        updatedItem.getName()
//                ).orElseThrow(() -> new IllegalArgumentException("Food Mapping not found."));
//        restaurantFoodMapping.setPrice(updatedItem.getPrice());
//        RestaurantFoodMapping result = restaurantFoodMappingRepository.save(restaurantFoodMapping);
//        return FoodDTO.builder().price(result.getPrice())
//                .name(result.getFood().getName())
//                .build();
//        Restaurant desiredRestaurant = restaurantRepository.findById(restaurantId);
//        if (desiredRestaurant != null) {
//            Food desiredFood = foodRepository.findByName(updatedItem.getName());
//            if (desiredFood != null) {
//                desiredRestaurant.getMenu().stream()
//                        .filter(item -> item.getFood().equals(desiredFood))
//                        .forEach(item -> {
//                            item.setPrice(updatedItem.getPrice());
//                            restaurantFoodMappingRepository.save(item);
//                        });
//                return getFoodByName(restaurantId, updatedItem.getName());
//            }
//        }
//        return null;
//    }

//    public boolean deleteAllFoods(long restaurantId) {
//        List<RestaurantFoodMapping> items = restaurantFoodMappingRepository.findByRestaurant_Id(restaurantId);
//
//        if (restaurantRepository.count() == 0) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public List<FoodDTO> deleteFoodByName(long restaurantId, String foodName) {
//
//        Restaurant desiredRestaurant = new Restaurant();
//        desiredRestaurant.setId(restaurantId);
//        List<RestaurantFoodMapping> items = restaurantFoodMappingRepository.findByRestaurant(desiredRestaurant);
//        return items.stream()
////        Restaurant desiredRestaurant = restaurantRepository.findById(restaurantId);
////        if (desiredRestaurant != null) {
////            Food desiredFood = foodRepository.findByName(foodName);
////            if (desiredFood != null) {
//                List<RestaurantFoodMapping> menu = desiredRestaurant.getMenu();
//                for (RestaurantFoodMapping item : menu) {
//                    if (item.getFood().equals(desiredFood)) {
//                        menu.remove(item);
//                    }
//                }
//                return getAllFoods(restaurantId);
//            }
//        }
//        return null;
//    }
}
