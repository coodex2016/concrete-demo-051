package org.coodex.concrete.demo.impl;

import lombok.extern.slf4j.Slf4j;
import org.coodex.concrete.message.MessageConsumer;
import org.coodex.concrete.message.Observer;

import javax.inject.Named;

@Named
@MessageConsumer(queue = "demo")
@Slf4j
public class DemoMessageListener implements Observer<String> {
    @Override
    public void update(String message) throws Throwable {
        log.info("message received: {}", message);
    }
}