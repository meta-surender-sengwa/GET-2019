package com.metacube.hibernate.model;

import javax.validation.constraints.Pattern;

/**
 * POJO class of Search Student
 * @author Surender
 */
public class Search {

	@Pattern(regexp = "[a-zA-Z]{3,20}", message = "{validFirstName}")
	String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
