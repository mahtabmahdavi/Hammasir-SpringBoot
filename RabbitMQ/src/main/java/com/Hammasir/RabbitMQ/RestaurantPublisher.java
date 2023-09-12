package com.Hammasir.RabbitMQ;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantPublisher {
    @Autowired
    private RabbitTemplate template;

    @PostMapping(value = "/publish")
    public String publishRestaurant(@RequestBody CustomRestaurant restaurant) {
        template.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY, restaurant);
        return "Restaurant published.";
    }
}
