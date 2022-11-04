package org.dmitrysulman.rabbitmq.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;

public class RabbitAmpqTutorialsRunner implements CommandLineRunner {

    @Value("${tutorial.client.duration:0}")
    private int duration;

    @Autowired
    private ConfigurableApplicationContext context;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Running for " + duration);
        Thread.sleep(duration);
        context.close();
    }
}
