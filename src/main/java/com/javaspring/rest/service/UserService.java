package com.javaspring.rest.service;

import java.util.List;

import com.javaspring.rest.model.User;
import com.javaspring.rest.repository.UserRepository;

public class UserService {
	
	UserRepository userRepository = new UserRepository();
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
}
