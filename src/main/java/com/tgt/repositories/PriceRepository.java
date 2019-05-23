package com.tgt.repositories;

import com.tgt.domain.Price;

/**
 * This interface represents product price get,update and set utility.
 * @author Chandra Bhan
 * @see PriceRepositoryImpl
 */
public interface PriceRepository {

	/**
	 * Fetch price of a product id based on given productId
	 * @param productId
	 * @return
	 * 
	 */
	public Price getPrice(String productId);

	/**
	 * Add price of newly added product
	 * @param productId
	 * @param price
	 */
	public void setNewProductPrice(String productId, Price price);

	/**
	 * Update price of existing product
	 * @param productId
	 * @param price
	 */
	public void updateProductPrice(String productId, Price price);

}
