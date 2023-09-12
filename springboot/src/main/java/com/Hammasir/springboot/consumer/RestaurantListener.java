package com.Hammasir.springboot.consumer;

import com.Hammasir.springboot.config.MQConfig;
import com.Hammasir.springboot.model.dto.RestaurantDTO;
import com.Hammasir.springboot.scheduling.ScheduledTasks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RestaurantListener {
    @RabbitListener(queues = MQConfig.QUEUE)
    public void listener(RestaurantDTO restaurant) {
        System.out.println(restaurant);
    }
}
