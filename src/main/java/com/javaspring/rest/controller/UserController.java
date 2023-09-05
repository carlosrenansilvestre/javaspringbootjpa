package com.javaspring.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaspring.rest.model.User;
import com.javaspring.rest.service.UserService;

import java.util.List;

@RestController

public class UserController {
	@GetMapping("/list-users") 
	public List<User> findAll() {
		UserService userService = new UserService();
		return userService.findAll();
	}
}
