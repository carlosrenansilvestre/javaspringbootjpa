package com.javaspring.rest.service;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.javaspring.rest.converter.Converter;
import com.javaspring.rest.dto.UserDTO;
import com.javaspring.rest.model.User;
import com.javaspring.rest.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	public UserRepository userRepository;
	
	public Iterable<UserDTO> findAll() {
		Iterable<User> users = userRepository.findAll();
		ArrayList<UserDTO> usersDTO = new ArrayList<UserDTO>();

		for (User user : users) {
			UserDTO userDTO = new UserDTO();
			Converter.convertModel(user, userDTO);
			usersDTO.add(userDTO);
        }
		
		return usersDTO;
	}  
	
	public UserDTO findById(Integer id) {
		Optional<User> user = userRepository.findById(id);
		UserDTO userDTO = new UserDTO();                    
		Converter.convertModel(user.get(), userDTO);  
		return userDTO;
	}

	public UserDTO insert(UserDTO user) {
		User userModel = new User();
		Converter.convertModel(user, userModel);
		User savedUser = userRepository.save(userModel);
		UserDTO userDTO = new UserDTO();
		Converter.convertModel(savedUser, userDTO);
		return userDTO;
	}
	
	public UserDTO edit(UserDTO user) {	
		User userModel = new User();
		BeanUtils.copyProperties(user, userModel);
		User userEdited = new User(
				userModel.getId(), 
				userModel.getName(), 
				userModel.getDocument(), 
				userModel.getRole()
		);
		User savedUser = userRepository.save(userEdited);
		UserDTO userDTO = new UserDTO();
		Converter.convertModel(savedUser, userDTO);
		return userDTO;
	}
}
