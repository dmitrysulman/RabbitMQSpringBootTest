package org.dmitrysulman.rabbitmq.springboot.tut6;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class Tut6Server {

    @RabbitListener(queues = "tut.rpc.requests")
    public long fibonacci(int n) {
        System.out.println(" [x] Received request for " + n);
        long result = fib(n);
        System.out.println(" [.] Returned " + result);
        return result;
    }

    public long fib(long n) {
        return n == 0 ? 0 : n == 1 ? 1 : (fib(n - 1) + fib(n - 2));
    }

}
