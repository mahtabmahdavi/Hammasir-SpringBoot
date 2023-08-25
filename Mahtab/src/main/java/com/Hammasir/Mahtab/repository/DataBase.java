package com.Hammasir.Mahtab.repository;

import com.Hammasir.Mahtab.model.Food;
import com.Hammasir.Mahtab.model.Restaurant;
import java.util.List;
import java.util.ArrayList;
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

//    public static List<Food> readFoods(String filePath) {
//        List<Food> foods = new ArrayList<>();
//        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                String name = line;
//                foods.add(new Food(name));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return foods;
//    }
}
