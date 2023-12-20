package com.example.TH75;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//Thực hành RestController và kiểm tra bằng Postman
@RestController
@RequestMapping("/api")
public class B7_5 {

    @GetMapping("/english")
    public String hello(){
        return "Hello World!!";
    }

    @GetMapping("/vietnamese")
    public String hello2() {
        return "Xin chao the gioi!!";
    }
}
