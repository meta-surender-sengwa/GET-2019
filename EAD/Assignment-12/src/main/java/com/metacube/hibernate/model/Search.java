package com.metacube.hibernate.model;

import javax.validation.constraints.Pattern;

/**
 * POJO class of Search Student
 * @author Surender
 */
public class Search {

	@Pattern(regexp = "[a-zA-Z]{3,20}", message = "{validFirstName}")
	String firstName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
}
