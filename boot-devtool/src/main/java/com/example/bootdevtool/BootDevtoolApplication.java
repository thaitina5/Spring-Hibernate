package com.example.bootdevtool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BootDevtoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootDevtoolApplication.class, args);
	}

	@GetMapping("/")
	public String hello(){
		return "xin chao THAI TIN 23445";
	}
}
