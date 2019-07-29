package com.udemy.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.udemy.currencyconversionservice.model.CurrencyConversion;
import com.udemy.currencyconversionservice.repository.CurrencyExchangeServiceProxy;

@RestController
public class CurrencyConversionController {

	private static final String CURRENCY_EXCHANGE_SERVICE_URI = "http://localhost:8000/currencyExchangeService/from/{fromCurrency}/to/{toCurrency}/";

	@Autowired
	private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;
	
	@GetMapping("/from/{fromCurrency}/to/{toCurrency}/quantity/{quantity}")
	public CurrencyConversion retrieveExchangeValue(@PathVariable String fromCurrency,
			@PathVariable String toCurrency, @PathVariable BigDecimal quantity) {

		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("fromCurrency", fromCurrency);
		uriVariables.put("toCurrency", toCurrency);

		try {
			ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate()
					.getForEntity(CURRENCY_EXCHANGE_SERVICE_URI, CurrencyConversion.class, uriVariables);

			CurrencyConversion response = responseEntity.getBody();

			return new CurrencyConversion(response.getId(), fromCurrency, toCurrency,
					response.getConservionMultiple(), quantity,
					quantity.multiply(response.getConservionMultiple()), response.getPort());
		} catch (RestClientException r) {
			throw new RestClientException("Currency exchange service not found.");
		}
	}
	
	@GetMapping("/feign/from/{fromCurrency}/to/{toCurrency}/quantity/{quantity}")
	public CurrencyConversion retrieveExchangeValueWithFeignClient(@PathVariable String fromCurrency,
			@PathVariable String toCurrency, @PathVariable BigDecimal quantity) {

		try {
			CurrencyConversion response = currencyExchangeServiceProxy.retrieveExchangeValue(fromCurrency, toCurrency);

			return new CurrencyConversion(response.getId(), fromCurrency, toCurrency,
					response.getConservionMultiple(), quantity,
					quantity.multiply(response.getConservionMultiple()), response.getPort());
		} catch (RuntimeException r) {
			r.printStackTrace();
			throw new RuntimeException("An error occurs.");
		}
	}
}
