package com.tgt.repositories;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tgt.domain.Price;
import com.tgt.domain.Product;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Chandra Bhan
 *
 */
@Slf4j
@Repository
public class ProductRepository {

	private static final Map<String, Product> productMap = new HashMap<String, Product>();

	@Autowired
	private PriceRepository priceRepository;

	/**
	 * @param product adds a new product and update price of product in priceRepo
	 */
	public void add(Product product) {
		priceRepository.setNewProductPrice(product.getId(), product.getPrice());
		productMap.put(product.getId(), product);
	}

	/**
	 * @param productID
	 * @return returns product corresponding to productId passed
	 */
	public Product getProduct(String productID) {
		return productMap.get(productID);
	}

	/**
	 * added dummy products
	 */
	@PostConstruct
	public void addData() {
		log.info("Product database setup started...");
		Product prod1 = new Product();
		String productId1 = "62736126";
		prod1.setId(productId1);
		prod1.setName("SHIRT");
		Price price1 = priceRepository.getPrice(productId1);
		prod1.setPrice(price1);

		Product prod2 = new Product();
		String productId2 = "62736127";
		prod2.setId(productId2);
		prod2.setName("MOBILE");
		Price price2 = priceRepository.getPrice(productId2);
		prod2.setPrice(price2);

		Product prod3 = new Product();
		String productId3 = "62736127";
		prod3.setId(productId3);
		prod3.setName("Television");
		Price price3 = priceRepository.getPrice(productId3);
		prod3.setPrice(price3);

		productMap.put("62736126", prod1);
		productMap.put("62736127", prod2);
		productMap.put("62736128", prod3);
		log.info("Product database setup completed...");
	}

	/**
	 * Update products price for the given productId
	 * 
	 * @param productId
	 * @param product
	 */
	public void updateData(String productId, Price price) {
		priceRepository.updateProductPrice(productId, price);
	}
}
