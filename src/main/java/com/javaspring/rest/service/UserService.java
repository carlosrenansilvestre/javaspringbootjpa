package com.javaspring.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaspring.rest.model.User;
import com.javaspring.rest.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	public UserRepository userRepository;
	
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}
}
