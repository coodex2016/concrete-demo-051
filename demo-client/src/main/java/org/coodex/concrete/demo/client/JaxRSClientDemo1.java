package org.coodex.concrete.demo.client;

import lombok.extern.slf4j.Slf4j;
import org.coodex.concrete.Client;
import org.coodex.concrete.demo.api.SubjoinExampleService;

@Slf4j
public class JaxRSClientDemo1 {
    public static void main(String[] args) {
        log.info("restful service invoked: {}",
                Client.getInstance(SubjoinExampleService.class,"demoModule").add(11, 12));
    }
}
