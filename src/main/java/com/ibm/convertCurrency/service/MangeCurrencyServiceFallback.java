package com.ibm.convertCurrency.service;

import com.ibm.convertCurrency.model.ConversionFactorResponse;

public class MangeCurrencyServiceFallback implements ManageCurrencyConversionProxy{

	@Override
	public ConversionFactorResponse getConversionFactor(String countryCode){
		System.out.println(" Default fallback response");
		ConversionFactorResponse response = new ConversionFactorResponse();
		response.setConversionFactor(1.00);
		return response;
	}
}
