package com.metacube.parking.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class Employee {
	
	@Pattern(regexp = "[a-zA-Z\\s]{3,20}", message = "{validFullName}")
	private String fullname;
	
	@NotBlank(message = "{blankGender}")
	private String gender;
	
	@NotBlank(message = "{blankEmail}")
	private String email;
	
	@Pattern(regexp = "[0-9]{10}", message = "{validContact}")
	private String contact;

	@NotBlank(message = "{blankOrganisation}")
	private String organisation;
		
	@NotBlank(message = "{blankPassword}")
	private String password;
	
	@NotBlank(message = "{blankConfirmPassword}")
	private String confirmPassword;

	public Employee(String fullname, String email, String gender, String organisation, String contact, String password, String confirmPassword) {
		super();
		this.fullname = fullname;
		this.email = email;
		this.gender = gender;
		this.organisation = organisation;
		this.contact = contact;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	public Employee() {

	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getOrganisation() {
		return organisation;
	}

	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
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

	public void setConfirmPassword(String confirmPasword) {
		this.confirmPassword = confirmPasword;
	}

	@Override
	public String toString() {
		return "Employee [fullname=" + fullname + ", email=" + email + ", gender=" + gender + ", organisation=" + organisation + ", contact=" + contact + ", password=" + password + ", confirmPasword=" + confirmPassword + "]";
	}
}