package org.coodex.concrete.demo.boot;

import org.coodex.config.Config;
import org.springframework.boot.SpringApplication;

public class MockBoot {

    public static void main(String[] args) {
        SpringApplication.run(DemoBootStarter.class, args);
        System.out.println( Config.get("zipkin.location"));
    }
}