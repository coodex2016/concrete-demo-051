package org.coodex.concrete.demo.client;

import lombok.extern.slf4j.Slf4j;
import org.coodex.concrete.Client;
import org.coodex.concrete.demo.api.CompletableSubjoinExampleService;

@Slf4j
public class AsyncAMQPClientDemo {
    public static void main(String[] args) {
        CompletableSubjoinExampleService subjoinExampleService = Client.getInstance(CompletableSubjoinExampleService.class, "amqpModule");
        subjoinExampleService.add(22, 33).thenAccept(integer -> log.info("async invoker amqp result: {}", integer));
    }
}
