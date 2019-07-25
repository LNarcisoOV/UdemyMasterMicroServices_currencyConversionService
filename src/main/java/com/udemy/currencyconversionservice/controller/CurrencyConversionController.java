package com.udemy.currencyconversionservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.currencyconversionservice.model.CurrencyConversion;

@RestController
public class CurrencyConversionController {

	@Autowired
	private Environment environment;

	@GetMapping("/from/{fromCurrency}/to/{toCurrency}/quantity/{quantity}")
	public CurrencyConversion retrieveExchangeValue(@PathVariable String fromCurrency,
			@PathVariable String toCurrency, @PathVariable BigDecimal quantity) {

		CurrencyConversion concurrentConversion = new CurrencyConversion(1000L, fromCurrency, toCurrency,
				BigDecimal.ONE, quantity, quantity, 0);

		// if (exchangeValue == null) {
		// throw new ExchangeValueNotFoundException("Exchange value not found");
		// }

		concurrentConversion.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return concurrentConversion;
	}
}
