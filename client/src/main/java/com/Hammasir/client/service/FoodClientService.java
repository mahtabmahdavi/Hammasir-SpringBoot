package com.Hammasir.client.service;

import com.Hammasir.client.model.Food;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class FoodClientService {
    private final WebClient webClient;

    public FoodClientService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080/food").build();
    }

    public List<Food> createFood(long restaurantId, Food food) {
        return webClient
                .post()
                .uri("/{id}", restaurantId)
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(food)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Food>>() {})
                .block();
    }

    public List<Food> getAllFoods(long restaurantId) {
        return webClient
                .get()
                .uri("/{id}/all", restaurantId)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Food>>() {})
                .block();
    }
}
