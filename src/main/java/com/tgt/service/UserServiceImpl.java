package com.tgt.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tgt.dao.Userdao;
import com.tgt.domain.User;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
	Userdao userdao;
	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub
		userdao.save(user);
	}

	@Override
	public Collection<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserById(String id) {
		// TODO Auto-generated method stub
		try {
		Optional<User> user= userdao.findById(id);
		
		System.out.println("user------------------------------"+user);
		return user.get();
		}catch(Exception e) {
			e.printStackTrace();
		}
	return null;
	}

	@Override
	public void deleteUserById(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllUsers() {
		// TODO Auto-generated method stub
		
	}
  
  }
 