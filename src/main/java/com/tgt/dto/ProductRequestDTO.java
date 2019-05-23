package com.tgt.dto;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductRequestDTO {

	@Expose
	@SerializedName("product_id")
	@Valid
	private String id;

	@Expose
	@SerializedName("product_name")
	@Valid
	private String name;

	@Expose
	@SerializedName("product_price")
	@Valid
	private PriceRequestDTO price;

	@JsonProperty("product_id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("product_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("product_price")
	public PriceRequestDTO getPrice() {
		return price;
	}

	public void setPrice(PriceRequestDTO price) {
		this.price = price;
	}

}
