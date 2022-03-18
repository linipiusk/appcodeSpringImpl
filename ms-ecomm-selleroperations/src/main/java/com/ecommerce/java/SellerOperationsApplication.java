package com.ecommerce.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class SellerOperationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SellerOperationsApplication.class, args);
	}

}
