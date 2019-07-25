package com.udemy.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.udemy.currencyconversionservice.model.CurrencyConversion;

@RestController
public class CurrencyConversionController {

	private static final String CURRENCY_EXCHANGE_SERVICE_URI = "http://localhost:8000/currencyExchangeService/from/{fromCurrency}/to/{toCurrency}/";

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
}