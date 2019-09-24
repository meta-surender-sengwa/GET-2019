package com.parkingsystem.model.pojo;

import javax.validation.constraints.NotBlank;

public class LoginPOJO {

	@NotBlank(message="please enter your email")
	private String email;
	
	@NotBlank(message="please enter your password")
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
