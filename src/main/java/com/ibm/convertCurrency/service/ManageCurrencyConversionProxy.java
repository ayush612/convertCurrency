package com.ibm.convertCurrency.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ibm.convertCurrency.model.ConversionFactorResponse;

@FeignClient(name = "manageCurrencyms")
public interface ManageCurrencyConversionProxy {

	@RequestMapping(value = "/conversionFactor/{countryCode}", method = RequestMethod.GET)
	public ConversionFactorResponse getConversionFactor(@PathVariable String countryCode);

}
