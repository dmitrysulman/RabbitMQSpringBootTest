package org.dmitrysulman.rabbitmq.springboot.tut5;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class Tut5Sender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private TopicExchange topicExchange;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        String message = "Hello world!";
        rabbitTemplate.convertAndSend(topicExchange.getName(), "routingKey1.", message + "1");
        rabbitTemplate.convertAndSend(topicExchange.getName(), "routingKey2.", message + "2");
        rabbitTemplate.convertAndSend(topicExchange.getName(), "routingKey12", message + "1");
        rabbitTemplate.convertAndSend(topicExchange.getName(), "routingKey12.asd", message + "12");
        System.out.println(" Sent message: " + message);
    }
}
