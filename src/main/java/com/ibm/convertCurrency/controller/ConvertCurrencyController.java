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
		Double convertedAmount = currencyRequest.getAmount() * currencyService.convertCurrency(currencyRequest);
		//Double convertedAmount = currencyRequest.getAmount() * currencyService.convertCurrencyLB(currencyRequest);
		//Double convertedAmount = currencyRequest.getAmount() * currencyService.convertCurrencyDiscovery(currencyRequest);
		if (Objects.isNull(convertedAmount)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(convertedAmount, HttpStatus.OK);
		}
	}
	
	@RequestMapping(path = "/v2", method = RequestMethod.POST)
	public ResponseEntity<Double> convertCurrencyLB(@RequestBody ConvertCurrencyRequest currencyRequest) {
		System.out.println("currencyRequest - > " + currencyRequest.toString());
		Double convertedAmount = currencyRequest.getAmount() * currencyService.convertCurrencyLB(currencyRequest);
		if (Objects.isNull(convertedAmount)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(convertedAmount, HttpStatus.OK);
		}
	}
	
	@RequestMapping(path = "/v3", method = RequestMethod.POST)
	public ResponseEntity<Double> convertCurrencyDiscoveryClient(@RequestBody ConvertCurrencyRequest currencyRequest) {
		System.out.println("currencyRequest - > " + currencyRequest.toString());
		Double convertedAmount = currencyRequest.getAmount() * currencyService.convertCurrencyDiscovery(currencyRequest);
		if (Objects.isNull(convertedAmount)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(convertedAmount, HttpStatus.OK);
		}
	}
}
