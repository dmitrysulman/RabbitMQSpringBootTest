package org.dmitrysulman.rabbitmq.springboot.tut4;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class Tut4Sender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private DirectExchange directExchange;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        String message = "Hello world!";
        rabbitTemplate.convertAndSend(directExchange.getName(), "routingKey1", message + "1");
        rabbitTemplate.convertAndSend(directExchange.getName(), "routingKey2", message + "2");
        rabbitTemplate.convertAndSend(directExchange.getName(), "routingKey12", message + "12");
        System.out.println(" Sent message: " + message);
    }
}
