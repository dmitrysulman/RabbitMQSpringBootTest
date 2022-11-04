package org.dmitrysulman.rabbitmq.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RabbitMqSpringBootTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitMqSpringBootTestApplication.class, args);
	}

	@Profile({"usage_message"})
	@Bean
	public CommandLineRunner usage() {
		return args -> System.out.println("Sample usage: java -jar rabbit-tutorials.jar --spring.profiles.active=hello-world,sender");
	}

	@Profile("!usage_message")
	@Bean
	public CommandLineRunner tutorial() {
		return new RabbitAmpqTutorialsRunner();
	}
}
