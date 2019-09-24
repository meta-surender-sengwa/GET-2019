package com.parkingsystem.model.pojo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class EmployeePOJO {

	@Pattern(regexp = "[a-zA-Z ]{2,30}", message = "{employeeName.Valid}")
	private String name;

	@NotBlank(message = "{gender.NotBlank}")
	private String gender;

	@NotBlank(message = "{email.NotBlank}")
	@Email(message = "{email.Valid}")
	private String email;

	@Pattern(regexp = "[0-9]{10}", message = "{phoneNumber.Valid}")
	private String phoneNumber;

	@NotBlank(message = "${company.NotBlank}")
	private String company;

	@Pattern(regexp = "[0-9]{8,16}", message = "{password.Valid}")
	private String password;

	@Pattern(regexp = "[0-9]{8,16}", message = "{confirmPassword.Valid}")
	private String confirmPassword;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
}
