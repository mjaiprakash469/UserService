package com.ibuy.user.demo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class AuthenticationRequest {

	@NotEmpty(message = "Please enter the Email id")
	@Email(message="Please provide a valid email address")
	private String email;
	
	@NotEmpty(message = "Please enter the password")
	private String password;

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
