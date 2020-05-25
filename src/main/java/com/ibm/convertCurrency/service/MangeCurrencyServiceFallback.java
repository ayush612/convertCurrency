package com.ibm.convertCurrency.service;

import com.ibm.convertCurrency.model.APIResponse;
import com.ibm.convertCurrency.model.ConversionFactorResponse;

public class MangeCurrencyServiceFallback implements ManageCurrencyConversionProxy{

	@Override
	public APIResponse<ConversionFactorResponse> getConversionFactor(String countryCode){
		System.out.println(" Default fallback response");
		APIResponse<ConversionFactorResponse> response = new APIResponse<>();
		response.setResponse(new ConversionFactorResponse(1000.00));
		response.setStatus(APIResponse.STATUS_SUCCESS);
		return response;
	}
}
