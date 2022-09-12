package com.transact.orderservice.kafka;

import com.transact.orderservice.model.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderResponseConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderResponseConsumer.class);

    @KafkaListener(
            topics = "${spring.kafka.response.topic.name}"
            ,groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(OrderEvent event){
        LOGGER.info(String.format("Order Response Result => %s", event.getMessage()));

    }

}
