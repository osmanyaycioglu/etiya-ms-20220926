package org.training.etiya.microservice.libresterror;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ErrorConfig {

    @Bean
    public ErrorAdvice errorAdvice(){
        return new ErrorAdvice();
    }

    @Bean
    public MyFeignErrorDecoder myFeignErrorDecoder(){
        return new MyFeignErrorDecoder();
    }
}
