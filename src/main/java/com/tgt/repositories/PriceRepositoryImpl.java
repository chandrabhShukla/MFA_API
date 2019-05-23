package com.tgt.repositories;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.tgt.domain.Price;

import lombok.extern.slf4j.Slf4j;

/**
 * @see PriceRepository
 * @author Chandra Bhan
 */
@Slf4j
@Repository
public class PriceRepositoryImpl implements PriceRepository {

	private static final Map<String, Price> priceMap = new HashMap<String, Price>();

	@Value("${api.price.enable:true}")
	Boolean isPriceAPIEnabled;

	@Override
	public Price getPrice(String productId) {
		if (isPriceAPIEnabled)
			return priceMap.get(productId);
		else
			return null;
	}

	// Added dummy product price
	@PostConstruct
	void addProductPrice() {
		if (isPriceAPIEnabled) {
			log.info("Product price database setup started...");
			Price price1 = new Price(100, "CND");
			Price price2 = new Price(1000, "USD");
			Price price3 = new Price(10000, "INR");
			priceMap.put("62736126", price1);
			priceMap.put("62736127", price2);
			priceMap.put("62736128", price3);
			log.info("Product price database setup completed...");
		}
	}

	@Override
	public void setNewProductPrice(String productId, Price price) {
		if (isPriceAPIEnabled)
			priceMap.put(productId, price);
	}

	@Override
	public void updateProductPrice(String productId, Price price) {
		if (isPriceAPIEnabled)
			priceMap.put(productId, price);
	}
}
