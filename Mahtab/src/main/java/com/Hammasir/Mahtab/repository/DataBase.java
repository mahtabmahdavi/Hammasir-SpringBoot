package com.Hammasir.Mahtab.repository;

import com.Hammasir.Mahtab.model.Food;
import com.Hammasir.Mahtab.model.MenuDTO;
import com.Hammasir.Mahtab.model.Restaurant;

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
                List<MenuDTO> menu = readRestaurantFoods("input/" + name + "-food.txt");
                Restaurant restaurant = new Restaurant(id, name);
                restaurant.setMenu(menu);
                restaurants.add(restaurant);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return restaurants;
    }

    public static List<MenuDTO> readRestaurantFoods(String filePath) {
        List<MenuDTO> menu = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String name = values[0];
                long price = Long.parseLong(values[1]);
                for (Food food : foodsList) {
                    if (food.getName().equals(name)) {
                        menu.add(new MenuDTO(name, price));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return menu;
    }
}
