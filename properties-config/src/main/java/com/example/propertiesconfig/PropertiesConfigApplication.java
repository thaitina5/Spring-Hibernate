package com.example.propertiesconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PropertiesConfigApplication {
	@Value("${family.dad}")
	private String dad;
	@Value("${family.mom}")
	private String mom;
	@Value("${family.brother}")
	private String brother;

	public static void main(String[] args) {
		SpringApplication.run(PropertiesConfigApplication.class, args);
	}

	@GetMapping("/")
	public String hello(){
		return "Xin chao THAI TIN";
	}

	@GetMapping("/info")
	public String info(){
		return
				"Dad: "+dad+"</br>"+
				"Mom: "+mom+"</br>"+
				"Brother: "+brother+"</br>";
	}

}
