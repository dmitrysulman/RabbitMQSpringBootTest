package org.dmitrysulman.rabbitmq.springboot.tut6;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"tut6", "rpc"})
@Configuration
public class Tut6Config {

    @Profile("client")
    private static class ClientConfig {

        @Bean
        public DirectExchange directExchange() {
            return new DirectExchange("tut.rpc");
        }

        @Bean
        public Tut6Client client() {
            return new Tut6Client();
        }

    }

    @Profile("server")
    private static class ServerConfig {

        @Bean
        public DirectExchange directExchange() {
            return new DirectExchange("tut.rpc");
        }


        @Bean
        public Queue queue() {
            return new Queue("tut.rpc.requests");
        }


        @Bean
        public Binding binding(DirectExchange directExchange, Queue queue) {
            return BindingBuilder.bind(queue).to(directExchange).with("rpc");
        }

        @Bean
        public Tut6Server server() {
            return new Tut6Server();
        }
    }
}
