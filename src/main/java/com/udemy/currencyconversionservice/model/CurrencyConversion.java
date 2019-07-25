package com.udemy.currencyconversionservice.model;

import java.math.BigDecimal;

public class CurrencyConversion {

	private Long id;
	private String fromCurrency;
	private String toCurrency;
	private BigDecimal conservionMultiple;
	private BigDecimal quantity;
	private BigDecimal totalCalculatedAmount;
	private int port;

	public CurrencyConversion() {
		super();
	}

	public CurrencyConversion(Long id, String fromCurrency, String toCurrency,
			BigDecimal conservionMultiple, BigDecimal quantity, BigDecimal totalCalculatedAmount, int port) {
		super();
		this.id = id;
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		this.conservionMultiple = conservionMultiple;
		this.quantity = quantity;
		this.totalCalculatedAmount = totalCalculatedAmount;
		this.port = port;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFromCurrency() {
		return fromCurrency;
	}

	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}

	public String getToCurrency() {
		return toCurrency;
	}

	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}

	public BigDecimal getConservionMultiple() {
		return conservionMultiple;
	}

	public void setConservionMultiple(BigDecimal conservionMultiple) {
		this.conservionMultiple = conservionMultiple;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}

	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
