package com.Hammasir.springboot.service;

import com.Hammasir.springboot.model.Restaurant;
import com.Hammasir.springboot.model.DTO.RestaurantDTO;
import com.Hammasir.springboot.repository.RestaurantRepository;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    private final ObjectMapper objectMapper;
    private final RestaurantRepository restaurantRepository;

    public RestaurantService(ObjectMapper objectMapper, RestaurantRepository restaurantRepository) {
        this.objectMapper = objectMapper;
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant createRestaurant(RestaurantDTO restaurant) {
        Restaurant createdRestaurant = getRestaurantByName(restaurant.getName());
        if (createdRestaurant == null) {
            return restaurantRepository.save(objectMapper.convertValue(restaurant, Restaurant.class));
        } else {
            return null;
        }
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurantById(long id) {
        return objectMapper.convertValue(restaurantRepository.findById(id), Restaurant.class);
    }

    public Restaurant getRestaurantByName(String name) {
        return objectMapper.convertValue(restaurantRepository.findByName(name), Restaurant.class);
    }

    public Restaurant updateRestaurant(RestaurantDTO restaurant) {
        Restaurant updatedRestaurant = restaurantRepository.findByName(restaurant.getName());
        if (updatedRestaurant != null) {
            updatedRestaurant.setName(restaurant.getName());
            updatedRestaurant.setPhoneNumber(restaurant.getPhoneNumber());
            updatedRestaurant.setAddress(restaurant.getAddress());
            return restaurantRepository.save(updatedRestaurant);
        } else {
            return null;
        }
    }

    public boolean deleteAllRestaurants() {
        restaurantRepository.deleteAll();
        if (restaurantRepository.count() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteRestaurantById(long id) {
        Restaurant deletedRestaurant = restaurantRepository.findById(id);
        if (deletedRestaurant != null) {
            restaurantRepository.deleteById(deletedRestaurant.getId());
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteRestaurantByName(String name) {
        Restaurant deletedRestaurant = restaurantRepository.findByName(name);
        if (deletedRestaurant != null) {
            restaurantRepository.deleteById(deletedRestaurant.getId());
            return true;
        } else {
            return false;
        }
    }
}
