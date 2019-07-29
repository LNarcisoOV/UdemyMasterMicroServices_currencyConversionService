package com.udemy.currencyconversionservice.repository;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.udemy.currencyconversionservice.model.CurrencyConversion;

//NAME should be the value in the property 'spring.application.name' in the 
//application.properties file of the microservice which will be consumed.
//URL should be the host and the port of the microservice.
//@FeignClient(name = "currencyExchangeService", url = "http://localhost:8000/currencyExchangeService")

//With RibbonClient annotation, we don't need to inform the URL in FeignClient annotation,
//but is necessary configure in application.properties file.

//If eureka is configured, you don't need to inform currencyExchangeService.ribbon.listOfServers
//in application.properties.
@FeignClient(name = "currencyExchangeService")
@RibbonClient(name = "currencyExchangeService")
public interface CurrencyExchangeServiceProxy {

	// Method which will be consumed in currency exchange microservice.
	@GetMapping("/from/{fromCurrency}/to/{toCurrency}")
	public CurrencyConversion retrieveExchangeValue(@PathVariable("fromCurrency") String fromCurrency,
			@PathVariable("toCurrency") String toCurrency);

}
