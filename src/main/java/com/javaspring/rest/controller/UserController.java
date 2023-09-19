package com.javaspring.rest.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaspring.rest.dto.UserDTO;
import com.javaspring.rest.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/list")
	public ResponseEntity<Iterable<UserDTO>> findAll() {
		Iterable<UserDTO> users = userService.findAll();
		return ResponseEntity.ok().body(users);
	}
	
	@GetMapping(value = "/find/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable("id") Integer id) {
		UserDTO user = userService.findById(id);
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping(value = "/insert")
	public ResponseEntity<UserDTO> findById(@RequestBody UserDTO user) {
		UserDTO userData = userService.insert(user);
		return ResponseEntity.ok().body(userData);
	}
	
	@PutMapping(value = "/edit")
	public ResponseEntity<UserDTO> edit(@RequestBody UserDTO user) {
		UserDTO userData = userService.findById(user.getId());
		if (userData != null) {
			UserDTO userEdited = userService.edit(user);
			return ResponseEntity.ok().body(userEdited);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
