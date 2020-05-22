package com.ibm.convertCurrency.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class ConversionFactorResponse implements Serializable {

	private static final long serialVersionUID = -9177141346463505118L;
	private Double conversionFactor;

	public Double getConversionFactor() {
		return conversionFactor;
	}

	public void setConversionFactor(Double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}

	public ConversionFactorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConversionFactorResponse(Double conversionFactor) {
		super();
		this.conversionFactor = conversionFactor;
	}
	
}
