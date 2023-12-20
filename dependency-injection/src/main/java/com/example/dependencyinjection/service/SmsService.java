package com.example.dependencyinjection.service;

import org.springframework.stereotype.Component;

@Component
public class SmsService implements MessageInterface {
    public SmsService(){
        System.out.println("Constructor: "+getClass().getSimpleName());
    }
    @Override
    public String sendMessage() {
        return "SMS sending...";
    }
}
