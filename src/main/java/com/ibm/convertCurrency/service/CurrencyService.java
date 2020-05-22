package com.ibm.convertCurrency.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.stereotype.Component;

import com.ibm.convertCurrency.model.APIResponse;
import com.ibm.convertCurrency.model.ConversionFactorResponse;
import com.ibm.convertCurrency.model.ConvertCurrencyRequest;

@Component
@RibbonClient(name = "manageCurrencyms")
public class CurrencyService {

	@Autowired
	private ManageCurrencyConversionProxy conversionProxy;

	public Double convertCurrency(ConvertCurrencyRequest currencyRequest) {
		APIResponse<ConversionFactorResponse> response =  conversionProxy.getConversionFactor(currencyRequest.getCountryCode());
		return response.getResponse().getConversionFactor();
	}

}
