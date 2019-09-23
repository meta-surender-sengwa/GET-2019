package com.metacube.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * POJO class of student.
 * @author Surender
 */
@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Sid")
	private int id;
	@NotBlank(message = "{blankFirstName}")
	String firstName;

	@NotBlank(message = "{blankLastName}")
	String lastName;
	

	@NotBlank(message = "{blankFatherName}")
	String fatherName;

	@Email(message = "{validEmail}")
	@NotBlank(message = "{blankEmail}")
	String email;

	
	@Pattern(regexp = "[1-12]+", message = "{validStudentClass}")
	@NotBlank(message ="{blankClass}")
	String studentClass;

	
	@Pattern(regexp = "[0-9]+", message = "{validAge}")
	@NotBlank(message = "{blankAge}")
	String age;
 
	public Student() {}

	/**
	 * Initialize the value.
	 * @param firstName
	 * @param lastName
	 * @param fatherName
	 * @param email
	 * @param studentClass
	 * @param age
	 */
	public Student(String firstName, String lastName, String fatherName,
			String email, String studentClass, String age) {
		this.age = age;
		this.email = email;
		this.fatherName = fatherName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentClass = studentClass;
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
