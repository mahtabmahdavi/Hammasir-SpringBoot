package com.Hammasir.client.service;

import com.Hammasir.client.model.Restaurant;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RestaurantClientService {
    private final RestTemplate restTemplate;

    public RestaurantClientService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Restaurant createRestaurant(Restaurant restaurant) {
        HttpEntity<Restaurant> entity = new HttpEntity<>(restaurant);
        return restTemplate.exchange("http://localhost:8080/restaurant", HttpMethod.POST, entity, Restaurant.class).getBody();
    }

    public List<Restaurant> getAllRestaurants() {
        return restTemplate.exchange("http://localhost:8080/restaurant/all", HttpMethod.GET, null, List.class).getBody();
    }
}
