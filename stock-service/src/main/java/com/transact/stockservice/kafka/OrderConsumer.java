package com.transact.stockservice.kafka;


import com.transact.stockservice.model.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    private OrderResponseProducer orderProducer;

    public OrderConsumer(OrderResponseProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @KafkaListener(
            topics = "${spring.kafka.topic.name}"
            ,groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(OrderEvent event){
        LOGGER.info(String.format("Order event received in stock service => %s", event.toString()));


        if(event.getOrder().getQty()>5){
            event.setMessage("TOO MUCH QNT NOT ALLOWED");
        }
        else {
            event.setMessage("QNT Allowed!!!");
        }

        orderProducer.sendMessage(event);

    }
}
