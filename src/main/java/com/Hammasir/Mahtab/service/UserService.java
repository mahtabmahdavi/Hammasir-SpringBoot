package com.Hammasir.Mahtab.service;

import com.Hammasir.Mahtab.model.*;
import com.Hammasir.Mahtab.repository.DataBase;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class UserService {
    private final List<Restaurant> restaurants = DataBase.readRestaurants("input/restaurant.txt");
    private final List<User> users = DataBase.readUsers();

    public static User findUser(String username, List<User> users) {
        return users.stream()
                .filter( user -> user.getUsername().equals(username))
                .findFirst()
                .orElse( null );
    }

    public static List<FoodDTO> helpToMakeOrder(List<Order> orders) {
        List<FoodDTO> items = new ArrayList<>();
        for (Order order : orders) {
            FoodDTO food = order.getItem();
            items.add(food);
        }
        return items;
    }

    public List<FoodDTO> getOrders(OrderDTO order) {
        User desiredUser = findUser(order.getUsername(), users);
        if (desiredUser != null) {
            Restaurant desiredRestaurant = RestaurantService.findRestaurant(order.getRestaurantId(), restaurants);
            if (desiredRestaurant != null) {
                FoodDTO desiredFood = FoodService.findFood(order.getFoodName(), desiredRestaurant);
                if (desiredFood != null) {
                    List<Order> userOrders = desiredUser.getOrders();
                    UUID orderId = UUID.randomUUID();
                    userOrders.add(new Order(orderId, desiredFood));
                    desiredUser.setOrders(userOrders);
                    return helpToMakeOrder(desiredUser.getOrders());
                }
            }
        }
        return null;
    }
}
