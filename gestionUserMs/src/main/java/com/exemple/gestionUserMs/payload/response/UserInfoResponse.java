package com.exemple.gestionUserMs.payload.response;

import com.exemple.gestionUserMs.entity.User;


public class UserInfoResponse {
	private String id;
	private String username;
	private String email;
	private User.ERole roles;

	public UserInfoResponse(String id, String username, String email, User.ERole roles) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.roles = roles;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public User.ERole getRoles() {
		return roles;
	}
}
