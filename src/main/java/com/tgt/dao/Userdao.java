package com.tgt.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tgt.domain.User;

@Repository
public interface Userdao extends MongoRepository<User, String> {


}

