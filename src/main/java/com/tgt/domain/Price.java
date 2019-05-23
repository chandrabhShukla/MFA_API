package com.tgt.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Chandra Bhan
 */


public class Price {

	@Getter
	@Setter
	private Double priceValue;
	@Getter
	@Setter
	private String currencyCode;

	public Price(double priceValue, String currencyCode) {
		super();
		this.priceValue = priceValue;
		this.currencyCode = currencyCode;
	}

}
