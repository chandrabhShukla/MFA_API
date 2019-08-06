package com.tgt.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.tgt.domain.User;

public class UserRepositoryCustom {
	
	@Autowired
	MongoTemplate mongoTemplate; 
	
	public void addUser(User user) {
		
		
	}

}
