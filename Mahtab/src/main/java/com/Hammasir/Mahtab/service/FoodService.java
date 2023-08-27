package com.Hammasir.Mahtab.service;

import com.Hammasir.Mahtab.model.FoodDTO;
import com.Hammasir.Mahtab.model.Restaurant;
import static com.Hammasir.Mahtab.model.Tool.findRestaurant;
import static com.Hammasir.Mahtab.repository.DataBase.readRestaurants;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    private final List<Restaurant> restaurants = readRestaurants( "input/restaurant.txt" );

    public boolean createFood(int restaurantId, MenuDTO newFood) {
        Restaurant desiredRestaurant = restaurantList.stream()
                .filter(restaurant -> restaurant.getId() == restaurantId)
                .findFirst()
                .orElse(null);
        List<MenuDTO> menu = desiredRestaurant.getMenu();
        for (MenuDTO food : menu) {
            if (!food.getName().equals(newFood.getName())) {
                menu.add(food);
                return true;
            }
        }
        return false;
    }

    public List<FoodDTO> readAllFoods(int id) {
        Restaurant desiredRestaurant = findRestaurant(id, restaurants);
        if (desiredRestaurant != null) {
            return desiredRestaurant.getMenu();
        }
        return null;
    }

    public FoodDTO readFoodByName(int id, String foodName) {
        Restaurant desiredRestaurant = findRestaurant(id, restaurants);
        if (desiredRestaurant != null) {
            return desiredRestaurant.getMenu().stream()
                    .filter( menu -> menu.getName().equals( foodName ) )
                    .findFirst()
                    .orElse( null );
        }
        return null;
    }

//    public Restaurant updateRestaurant(int id, RestaurantDTO restaurant) {
//        Restaurant updatedRestaurant = new Restaurant( restaurant.getId(), restaurant.getName() );
//        return restaurantList.stream()
//                .filter( r -> r.getId() == id )
//                .findFirst()
//                .map( r -> {
//                    r.setId( updatedRestaurant.getId() );
//                    r.setName( updatedRestaurant.getName() );
//                    return r;
//                } )
//                .orElse( null );
//    }
//
    public boolean deleteAllFoods(int id) {
        Restaurant desiredRestaurant = findRestaurant(id, restaurants);
        if (desiredRestaurant != null) {
            desiredRestaurant.setMenu(null);
            return true;
        }
        return false;
    }

    public boolean deleteFoodByName(int id, String foodName) {
        Restaurant desiredRestaurant = findRestaurant(id, restaurants);
        if (desiredRestaurant != null) {
            FoodDTO deletedFood = desiredRestaurant.getMenu().stream()
                    .filter( food -> food.getName().equals( foodName ) )
                    .findFirst()
                    .orElse( null );
            List<FoodDTO> menu = desiredRestaurant.getMenu();
            menu.remove( deletedFood );
            return true;
        }
        return false;
    }
}