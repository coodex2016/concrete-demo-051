package org.coodex.concrete.demo.boot;

import org.coodex.concrete.core.intercept.LicenseCheckInterceptor;
import org.coodex.concrete.core.intercept.ProductionValidationInterceptor;
import org.coodex.concrete.spring.boot.EnableConcreteAMQP;
import org.coodex.concrete.spring.boot.EnableConcreteJAXRS;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
        scanBasePackages = "org.coodex.concrete.demo.**.impl"
)
// 启用concrete jaxrs
@EnableConcreteJAXRS(
        servicePackages = "org.coodex.concrete.demo.**.api"
)
@EnableConcreteAMQP(
        servicePackages = "org.coodex.concrete.demo.**.api"
)
@EnableDiscoveryClient
public class DemoBootStarter {

    @Bean
    public LicenseCheckInterceptor licenseCheckInterceptor() {
        return new LicenseCheckInterceptor();
    }

    @Bean
    public ProductionValidationInterceptor productionValidationInterceptor() {
        return new ProductionValidationInterceptor();
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoBootStarter.class, args);
    }

}