package org.training.etiya.microservice.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Controller
//@Repository
//@Service
@Configuration
public class GreetingsConfig {

    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public GreetingsEng myGreetings() {
        return new GreetingsEng();
    }

    @Bean
    public GreetingsEng myGreetings2() {
        return new GreetingsEng();
    }

    @Bean
    public GreetingsDyn myGreetingsDyn() {
        String hello = applicationContext.getEnvironment()
                                         .getProperty("app.greeting.prefix",
                                                      "hello");
        return new GreetingsDyn(hello);
    }

    @Bean
    public GreetingsDyn myGreetingsDyn2(Environment environment) {
        String hello = environment.getProperty("app.greeting.prefix",
                                               "hello");
        return new GreetingsDyn(hello);
    }

    @Bean
    public GreetingsDyn myGreetingsDyn3(@Value("${app.greeting.prefix}") String prefix) {
        return new GreetingsDyn(prefix);
    }

}
