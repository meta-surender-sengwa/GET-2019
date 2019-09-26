package com.metacube.assignment.dto;

/**
 * This class contain details for book update
 * @author Surender
 */
public class UpdateBook {

	private int id;
	private String publisher;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
}
