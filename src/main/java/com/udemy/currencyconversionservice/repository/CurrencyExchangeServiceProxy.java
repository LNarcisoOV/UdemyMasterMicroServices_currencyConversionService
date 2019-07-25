package com.udemy.currencyconversionservice.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.udemy.currencyconversionservice.model.CurrencyConversion;

//NAME should be the value in the property 'spring.application.name' in the 
//application.properties file of the microservice wich will be consumed.
//URL should be the host and the port of the microservice.
@FeignClient(name = "currencyExchangeService", url = "localhost:8000")
public interface CurrencyExchangeServiceProxy {

	//Method whitch will be consumed in currency exchange microservice.
	@GetMapping("/from/{fromCurrency}/to/{toCurrency}")
	public CurrencyConversion retrieveExchangeValue(@PathVariable String fromCurrency,
			@PathVariable String toCurrency);

}
