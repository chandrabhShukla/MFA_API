package com.tgt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tgt.domain.Price;
import com.tgt.repositories.PriceRepository;

@Service
public class PriceService {

	@Autowired
	PriceRepository priceRepository;
	
	public Price getPrice(String productId) {
		return priceRepository.getPrice(productId);
	}

	public void setNewProductPrice(String productId, Price price) {
		priceRepository.setNewProductPrice(productId, price);
	}

	public void updateProductPrice(String productId, Price price) {
		priceRepository.updateProductPrice(productId, price);
	}
}
