package com.example.dependencyinjection.rest;

import com.example.dependencyinjection.service.MessageInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotifController {
//    @Autowired //Field Injection
    public MessageInterface service;

    @Autowired
    public NotifController(@Qualifier("emailService") MessageInterface service){
        this.service = service;
    }

//    @Autowired
//    public void setEmail(EmailService email){
//        this.email = email;
//    }

    @GetMapping("/send-message")
    public String sendEmail(){
        return this.service.sendMessage();
    }
}
