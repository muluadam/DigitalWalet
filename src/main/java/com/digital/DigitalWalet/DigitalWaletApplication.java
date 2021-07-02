package com.digital.DigitalWalet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@RestController
public class DigitalWaletApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalWaletApplication.class, args);
	}

	@GetMapping("/")
	public String get(){
		return "Hello Alex";
	}
}
