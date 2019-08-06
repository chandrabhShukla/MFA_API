package com.tgt.service;

import java.util.Collection;

import com.tgt.domain.User;


public interface UserService {

	/**
	 * Method to create new employees in the db using mongo-db repository.
	 * @param emp
	 */
	public void createUser(User user);

	/**
	 * Method to fetch all employees from the db using mongo-db repository.
	 * @return
	 */
	public Collection<User> getAllUsers();

	/**
	 * Method to fetch employee by id using mongo-db repository.
	 * @param id
	 * @return
	 */
	public User findUserById(String id);

	/**
	 * Method to delete employee by id using mongo-db repository.
	 * @param id
	 */
	public void deleteUserById(String id);

	/**
	 * Method to update employee by id using mongo-db repository.
	 * @param id
	 */
	public void updateUser(User user);

	/**
	 * Method to delete all employees using mongo-db repository.
	 */
	public void deleteAllUsers();

}