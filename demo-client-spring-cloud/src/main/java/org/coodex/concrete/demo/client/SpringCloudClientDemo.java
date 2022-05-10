package org.coodex.concrete.demo.client;

import org.coodex.concrete.Client;
import org.coodex.concrete.ConcreteClient;
import org.coodex.concrete.client.spring.SpringJaxRSDestination;
import org.coodex.concrete.demo.api.SubjoinExampleService;
import org.coodex.concrete.spring.ConcreteSpringConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

import javax.inject.Inject;

@EnableDiscoveryClient // 自动发现
@SpringBootApplication
@Import(ConcreteSpringConfiguration.class) //引入concrete-spring支持
public class SpringCloudClientDemo {

    // 注入方式，需要在Config中配置此模块的信息
    @Inject
    @ConcreteClient("spring-cloud-client-demo")
    private SubjoinExampleService subjoinExampleService;


    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringCloudClientDemo.class, args);

        // DI demo
        SpringCloudClientDemo demo = context.getBean(SpringCloudClientDemo.class);
        System.out.println(demo.subjoinExampleService.add(11, 22));

        // Destination 模式
        SpringJaxRSDestination destination = new SpringJaxRSDestination();
        destination.setMicroService(true);
        destination.setLocation("http://demo-service/jaxrs"); //使用服务名调用
        SubjoinExampleService exampleService = Client.getInstance(SubjoinExampleService.class, destination);
        System.out.println(exampleService.add(1, 2));
    }
}