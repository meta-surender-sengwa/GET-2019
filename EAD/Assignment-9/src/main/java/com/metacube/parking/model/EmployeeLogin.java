package com.metacube.parking.model;

import javax.validation.constraints.NotBlank;

public class EmployeeLogin {

	@NotBlank(message = "{blanklEmail}")
	private String email;

	@NotBlank(message = "{blankPassword}")
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

	public EmployeeLogin(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public EmployeeLogin() {
	}

	@Override
	public String toString() {
		return "EmployeeLogin [email=" + email + ", password=" + password + "]";
	}
}
