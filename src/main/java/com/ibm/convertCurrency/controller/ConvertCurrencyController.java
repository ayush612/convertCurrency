package com.ibm.convertCurrency.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.convertCurrency.model.ConvertCurrencyRequest;
import com.ibm.convertCurrency.service.CurrencyService;

@RestController
@RequestMapping("/convertCurrency")
public class ConvertCurrencyController {

	@Autowired
	private CurrencyService currencyService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Double> convertCurrency(@RequestBody ConvertCurrencyRequest currencyRequest) {
		System.out.println("currencyRequest - > " + currencyRequest.toString());
		Double convertedAmount = 100 * currencyService.convertCurrency(currencyRequest);//currencyRequest.getAmount() * 100;
		if (Objects.isNull(convertedAmount)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(convertedAmount, HttpStatus.OK);
		}
	}
}
