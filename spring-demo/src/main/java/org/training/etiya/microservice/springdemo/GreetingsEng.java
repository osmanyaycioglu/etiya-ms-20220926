package org.training.etiya.microservice.springdemo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class GreetingsEng {
    int counter = 0;
    public String hello(String name){
        return "hello " + name + " counter : " + counter++;
    }

    public String goodbye(String name){
        return "Goodbye " + name;
    }

}
