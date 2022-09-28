package org.training.etiya.microservice.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;
import org.training.etiya.microservice.libresterror.ErrorConfig;

@SpringBootApplication
@EnableEurekaClient
@Import(ErrorConfig.class)
public class MsCustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsCustomerApplication.class,
                              args);
    }

}
