package com.javaspring.rest.dto;

public class UserDTO {
	public Integer id;
	public String name;
	public String document;
	public Integer role;
	
	public UserDTO(Integer id, String name, String document, Integer role) {
		super();
		this.id = id;
		this.name = name;
		this.document = document;
		this.role = role;
	}
	
	public UserDTO() {
		
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDocument() {
		return document;
	}
	
	public void setDocument(String document) {
		this.document = document;
	}
	
	public Integer getRole() {
		return role;
	}
	
	public void setRole(Integer role) {
		this.role = role;
	}
}
