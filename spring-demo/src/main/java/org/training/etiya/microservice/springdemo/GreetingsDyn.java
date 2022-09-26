package org.training.etiya.microservice.springdemo;

import org.springframework.stereotype.Component;

// @Component
public class GreetingsDyn {
    private String prefix;

    public GreetingsDyn(String prefix) {
        this.prefix = prefix;
    }

    public String hello(String name) {
        return prefix + " " + name ;
    }

    public String goodbye(String name) {
        return "Goodbye " + name;
    }
}
