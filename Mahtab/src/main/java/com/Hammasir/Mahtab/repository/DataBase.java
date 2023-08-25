package com.Hammasir.Mahtab.repository;

import com.Hammasir.Mahtab.model.Food;
import com.Hammasir.Mahtab.model.Restaurant;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.io.*;

public class DataBase {
    public static List<Restaurant> readRestaurants(String filePath) {
        List<Restaurant> restaurants = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split( "," );
                int id = Integer.parseInt(values[0]);
                String name = values[1];
                restaurants.add(new Restaurant(id, name));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return restaurants;
    }

    public static Map<Long, Food> readFoods(String filePath) {
        Map<Long, Food> foods = new HashMap<Long, Food>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split( "," );
                String name = values[0];
                Long price = Long.parseLong(values[1]);
                foods.put(price, new Food(name));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return foods;
    }
}
