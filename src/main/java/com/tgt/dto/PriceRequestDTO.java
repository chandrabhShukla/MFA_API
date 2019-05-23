package com.tgt.dto;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PriceRequestDTO {

	@Expose
	@SerializedName("price_value")
	@Valid
	private Double priceValue;

	@Expose
	@SerializedName("currency_code")
	@Valid
	private String currencyCode;

	@JsonProperty("price_value")
	public Double getPriceValue() {
		return priceValue;
	}

	public void setPriceValue(Double priceValue) {
		this.priceValue = priceValue;
	}

	@JsonProperty("currency_code")
	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

}
