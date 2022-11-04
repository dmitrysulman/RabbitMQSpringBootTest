package org.dmitrysulman.rabbitmq.springboot.tut3;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class Tut3Receiver {
    public Tut3Receiver() {
    }

    @RabbitListener(queues = "#{autoDeleteQueue1.name}")
    public void receive1(String in) {
        System.out.println("Received on 1: " + in);
    }

    @RabbitListener(queues = "#{autoDeleteQueue2.name}")
    public void receive2(String in) {
        System.out.println("Received on 2: " + in);
    }
}
