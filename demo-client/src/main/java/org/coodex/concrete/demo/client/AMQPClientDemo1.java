package org.coodex.concrete.demo.client;

import lombok.extern.slf4j.Slf4j;
import org.coodex.concrete.Client;
import org.coodex.concrete.demo.api.SubjoinExampleService;

@Slf4j
public class AMQPClientDemo1 {
    public static void main(String[] args) {
        log.info("amqp service invoked: {}",
                Client.getInstance(SubjoinExampleService.class, "amqpModule").add(11, 12));
    }
}
