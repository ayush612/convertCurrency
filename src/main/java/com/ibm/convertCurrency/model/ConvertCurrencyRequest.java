package com.ibm.convertCurrency.model;

public class ConvertCurrencyRequest {

	private String countryCode;
	private Double amount;

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "ConvertCurrencyRequest [countryCode=" + countryCode + ", amount=" + amount + "]";
	}

	public ConvertCurrencyRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConvertCurrencyRequest(String countryCode, Double amount) {
		super();
		this.countryCode = countryCode;
		this.amount = amount;
	}

}
