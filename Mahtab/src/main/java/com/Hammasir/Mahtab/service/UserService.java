package com.Hammasir.Mahtab.service;

import com.Hammasir.Mahtab.model.*;
import static com.Hammasir.Mahtab.model.Tool.*;
import static com.Hammasir.Mahtab.repository.DataBase.readRestaurants;
import static com.Hammasir.Mahtab.repository.DataBase.readUsers;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class UserService {
    Random rand = new Random();
    private final List<Restaurant> restaurants = readRestaurants( "input/restaurant.txt" );
    private final List<User> users = readUsers("input/user.txt");

    public List<FoodDTO> getOrders(String username, OrderDTO order) {
        User desiredUser = findUser( username, users );
        if (desiredUser != null) {
            Restaurant desiredRestaurant = findRestaurant( order.getRestaurantId(), restaurants );
            if (desiredRestaurant != null) {
                FoodDTO desiredFood = findFood( order.getFoodName(), desiredRestaurant );
                if (desiredFood != null) {
                    List<Order> userOrders = desiredUser.getOrders();
                    int orderId = rand.nextInt( 1000 );
                    userOrders.add( new Order( orderId, desiredFood ) );
                    desiredUser.setOrders( userOrders );
                    return helpToMakeOrder( desiredUser.getOrders() );
                }
            }
        }
        return null;
    }
}
