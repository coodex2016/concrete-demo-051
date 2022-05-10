package org.coodex.concrete.demo.client;

import lombok.extern.slf4j.Slf4j;
import org.coodex.concrete.Client;
import org.coodex.concrete.client.Destination;
import org.coodex.concrete.client.jaxrs.JaxRSDestination;
import org.coodex.concrete.demo.api.SubjoinExampleService;

@Slf4j
public class JaxRSClientDemo2 {
    public static void main(String[] args) {
        Destination destination = new JaxRSDestination();
        destination.setLocation("http://localhost:8080/jaxrs");
        log.info("restful service invoked: {}",
                Client.getInstance(SubjoinExampleService.class, destination).add(11, 12));
    }
}
