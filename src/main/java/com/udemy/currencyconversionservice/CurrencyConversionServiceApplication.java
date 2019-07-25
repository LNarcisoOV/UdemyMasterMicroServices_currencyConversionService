package com.udemy.currencyconversionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//Package for the Spring Boot's version 2.0.0.M4.
@EnableFeignClients(basePackages = {"org.springframework.cloud.openfeign.*"
		, "com.udemy.currencyconversionservice.repository"})
public class CurrencyConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionServiceApplication.class, args);
	}

}
