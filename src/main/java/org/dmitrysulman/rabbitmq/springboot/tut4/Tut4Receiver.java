package org.dmitrysulman.rabbitmq.springboot.tut4;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class Tut4Receiver {
    public Tut4Receiver() {
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
