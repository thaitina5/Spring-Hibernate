package com.example.dependencyinjection.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
//@Lazy
public class ZaloService implements MessageInterface {
    public ZaloService(){
        System.out.println("Constructor: "+getClass().getSimpleName());
    }
    @Override
    public String sendMessage() {
        return "Zalo sending...";
    }
}
