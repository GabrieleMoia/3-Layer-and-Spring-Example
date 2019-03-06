package com.example.sources;

import javax.inject.Named;

@Named("helloService")
public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }
}
