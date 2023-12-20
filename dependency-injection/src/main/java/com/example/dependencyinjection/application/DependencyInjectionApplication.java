package com.example.dependencyinjection.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackages = {
				"net.twitch",
				"com.example.dependencyinjection.application",
				"com.example.dependencyinjection.rest",
				"com.example.dependencyinjection.service"
		}
)
public class DependencyInjectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(DependencyInjectionApplication.class, args);
	}

}
