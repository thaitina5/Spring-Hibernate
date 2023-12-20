package com.example.dependencyinjection.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class EmailService implements MessageInterface {

    @PostConstruct
    public void init(){
        System.out.println("Doan code nay run SAU KHI TAO: "+getClass().getSimpleName());
    }

    @PreDestroy
    public void myDestroy(){
        System.out.println("Doan code nay run TRUOC khi huy: "+getClass().getSimpleName());
    }

    public EmailService(){
        System.out.println("Constructor: "+getClass().getSimpleName());
    }

    @Override
    public String sendMessage() {
        return "Email sending...lazy";
    }
}

