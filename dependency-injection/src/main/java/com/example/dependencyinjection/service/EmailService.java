package com.example.dependencyinjection.service;

import org.springframework.stereotype.Component;

@Component
public class EmailService implements MessageInterface {
    public EmailService(){
        System.out.println("Constructor: "+getClass().getSimpleName());
    }
    @Override
    public String sendMessage() {
        return "Email sending...lazy";
    }
}

