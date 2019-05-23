package com.tgt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tgt.domain.Price;
import com.tgt.domain.Product;
import com.tgt.repositories.PriceRepository;
import com.tgt.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private PriceRepository priceRepository;

	public void add(Product product) {
		productRepository.add(product);

	}

	public Product getProduct(String productID) {

		Product product = productRepository.getProduct(productID);

		if (product == null)
			return null;

		Price price = priceRepository.getPrice(productID);
		product.setPrice(price);
		return product;

	}

	public void updateData(String productId, Price price) {
		productRepository.updateData(productId, price);

	}
}
