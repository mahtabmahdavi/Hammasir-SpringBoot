package com.Hammasir.Mahtab.repository;

import com.Hammasir.Mahtab.config.BasicAuthWebSecurityConfiguration;
import com.Hammasir.Mahtab.model.*;

import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class DataBase {
    private static final List<Food> foodsList = readFoods("input/food.txt");

    public static List<Food> readFoods(String filePath) {
        List<Food> foods = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                int id = Integer.parseInt(values[0]);
                String name = values[1];
                foods.add(new Food(id, name));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return foods;
    }

    public static List<Restaurant> readRestaurants(String filePath) {
        List<Restaurant> restaurants = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                int id = Integer.parseInt(values[0]);
                String name = values[1];
                List<FoodDTO> menu = readRestaurantFoods("input/menu/" + name + ".txt");
                Restaurant restaurant = new Restaurant(id, name);
                restaurant.setMenu(menu);
                restaurants.add(restaurant);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return restaurants;
    }

    public static List<FoodDTO> readRestaurantFoods(String filePath) {
        List<FoodDTO> menu = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String name = values[0];
                long price = Long.parseLong(values[1]);
                for (Food food : foodsList) {
                    if (food.getName().equals(name)) {
                        menu.add(new FoodDTO(name, price));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return menu;
    }

    public static List<User> readUsers() {
        List<User> users = new ArrayList<>();
        users.add( new User( "mahtabmahdavi",
                BasicAuthWebSecurityConfiguration.passwordEncoder().encode( "1234admin" ), "ADMIN" ) );
        users.add( new User( "testuser",
                BasicAuthWebSecurityConfiguration.passwordEncoder().encode( "pass842word" ), "USER" ) );
        return users;
    }
}
