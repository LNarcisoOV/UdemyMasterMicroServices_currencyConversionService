package com.udemy.currencyconversionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableDiscoveryClient
//Package for the Spring Boot's version 2.0.0.M4.
@EnableFeignClients(basePackages = {"org.springframework.cloud.openfeign.*"
		, "com.udemy.currencyconversionservice.repository"})
public class CurrencyConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionServiceApplication.class, args);
	}
	
	@Bean
	public Sampler defaulSampler(){
		return Sampler.ALWAYS_SAMPLE;
	}

}
