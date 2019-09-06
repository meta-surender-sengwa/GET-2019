package com.metacube.assignment.model;

/**
 * This class repsents a base entity
 * @author Surender
 */
public class BaseEntity {

	private int id;

	public BaseEntity() {
    }
	
	public BaseEntity(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
}
