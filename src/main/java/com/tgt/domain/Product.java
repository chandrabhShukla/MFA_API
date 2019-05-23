package com.tgt.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Chandra Bhan
 */

public class Product {
    @Getter
    @Setter
	private String id;
    @Getter
    @Setter
	private String name;
    @Getter
    @Setter
	private Price price;

	public Product() {
		super();
	}

	public Product(String id, String name, Price price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

}
