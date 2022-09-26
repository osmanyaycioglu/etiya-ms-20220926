package org.training.etiya.microservice.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class GreetingsRun implements CommandLineRunner {

    @Autowired
    @Qualifier("myGreetings")
    private GreetingsEng greetingsEng1;

    private GreetingsEng greetingsEng2;

    private GreetingsEng greetingsEng3;

    public GreetingsRun() {
    }

    @Autowired
    public GreetingsRun(@Qualifier("greetingsEng") GreetingsEng greetingsEng2) {
        System.out.println("GreetingsRun yaratıldı");
        this.greetingsEng2 = greetingsEng2;
    }

    @PostConstruct
    public void init() {
        System.out.println("Cosntruct");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroy");
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(greetingsEng1.hello("osman1"));
        System.out.println(greetingsEng2.hello("osman2"));
        System.out.println(greetingsEng3.hello("osman3"));
    }

    public GreetingsEng getGreetingsEng3() {
        return greetingsEng3;
    }

    @Autowired
    public void setGreetingsEng3(@Qualifier("myGreetings2") GreetingsEng greetingsEng3) {
        this.greetingsEng3 = greetingsEng3;
    }
}
