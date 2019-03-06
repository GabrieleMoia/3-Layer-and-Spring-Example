package com.example.main;

import com.example.sources.HelloService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.inject.Named;

@ComponentScan("com.example.sources") //serve per indicare le classi diverse da dove si trova il main
@SpringBootApplication
public class MainObject implements CommandLineRunner {
    HelloService helloService;
    public MainObject(
            @Named("helloService") HelloService helloService) {
        this.helloService = helloService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainObject.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
            helloService.sayHello(strings[0]);
    }
}