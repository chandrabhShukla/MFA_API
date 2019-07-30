package com.tgt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tgt.domain.User;
import com.tgt.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;



	public void add(User user) {
		userRepository.add(user);

	}

	public User getUser(String userID) {

		User user = userRepository.getUser(userID);

		if (user == null)
			return null;


		return user;

	}

}