package com.ibm.convertCurrency.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ibm.convertCurrency.model.ConversionFactorResponse;
import com.ibm.convertCurrency.model.ConvertCurrencyRequest;

@Component
@RibbonClient(name = "manageCurrencyms")
public class CurrencyService {

	@Autowired
	LoadBalancerClient lbClient;

	@Bean
	@LoadBalanced
	RestTemplate createRestTemplate() {
		RestTemplateBuilder b = new RestTemplateBuilder();
		return b.build();
	}

	@Autowired
	private ManageCurrencyConversionProxy conversionProxy;

	public Double convertCurrency(ConvertCurrencyRequest currencyRequest) {
		ConversionFactorResponse response = conversionProxy.getConversionFactor(currencyRequest.getCountryCode());
		if (Objects.nonNull(response)) {
			return response.getConversionFactor();
		}
		return 0.0;
	}

	public Double convertCurrencyLB(ConvertCurrencyRequest currencyRequest) {
		ServiceInstance instance = lbClient.choose("manageCurrencyms");
		String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/conversionFactor/{countryCode}";
		System.out.println("url -> " +url);
		RestTemplate restTemplate = new RestTemplate();
		//HttpEntity<?> entity = new HttpEntity<>();
		ResponseEntity<ConversionFactorResponse> dResponseEntity = 
				restTemplate.exchange(url, HttpMethod.GET, null,
				ConversionFactorResponse.class, currencyRequest.getCountryCode());

		return dResponseEntity.getBody().getConversionFactor();
	}

}
