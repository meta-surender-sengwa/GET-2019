package com.metacube.sms.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class Student {
	
	@NotBlank(message = "{blankFirstName}")
	private String firstName;
	
	@NotBlank(message = "{blankLastName}")
	private String lastName;
	
	@NotBlank(message = "{blankFatherName}")
	private String fatherName;
	
	@Email(message = "{validEmail}")
	@NotBlank(message = "{blankEmail}")
	private String email;
	
	@Pattern(regexp = "[1-12]+", message = "{validStudentClass}")
	@NotBlank(message = "{blankClass}")
	private String studentClass;
	
	@Pattern(regexp = "[0-9]+", message = "{validAge}")
	@NotBlank(message = "{blankAge}")
	private String age;

	public Student(){
		
	}
		
	public Student(String firstName, String lastName, String fatherName, String emailId, String studentClass, String age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.email = emailId;
		this.studentClass = studentClass;
		this.age = age;
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
}
