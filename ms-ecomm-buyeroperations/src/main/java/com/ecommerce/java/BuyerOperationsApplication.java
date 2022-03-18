package com.ecommerce.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class BuyerOperationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuyerOperationsApplication.class, args);
	}

}
