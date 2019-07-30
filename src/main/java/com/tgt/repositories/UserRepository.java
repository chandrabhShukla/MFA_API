package com.tgt.repositories;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.tgt.domain.User;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Chandra Bhan
 *
 */
@Slf4j
@Repository
public class UserRepository {

	private static final Map<String, User> userMap = new HashMap<String, User>();

	/**
	 * @param product adds a new product and update price of product in priceRepo
	 */
	public void add(User user) {

		userMap.put(user.getId(),user);
	}

	/**
	 * @param productID
	 * @return returns product corresponding to productId passed
	 */
	public User getUser(String userId) {
		return userMap.get(userId);
	}

	/**
	 * added dummy products
	 */
	@PostConstruct
	public void addData() {
		
		User user1 = new User();
		String userId1 = "chandrabhan@gmail.com";
		user1.setId(userId1);
		user1.setName("Chandra");


		User user2 = new User();
		String userId2 = "Rama@gmail.com";
		user2.setId(userId2);
		user2.setName("RAMA");


		userMap.put(userId1, user1);
		userMap.put(userId2, user2);
	}


}