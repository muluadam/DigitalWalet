package com.digital.DigitalWalet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@RestController
@Configuration

@SpringBootApplication  //added for MySQL

@EnableScheduling
public class DigitalWaletApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalWaletApplication.class, args);
	}

	@GetMapping("/")
	public String get(){

		return "Hello Alex";
	}
}
