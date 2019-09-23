package com.metacube.springsecurity.dao;

import java.util.List;

import com.metacube.springsecurity.model.Student;

/**
 * Interface for Student DAO
 * @author Surender
 *
 */
public interface IStudentDao {
	
	/**
	 * Method to add student to database
	 * @param student is the student
	 */
	public void addStudnet(Student student);
	
	/**
	 * Method to get list of all students from database
	 * @return the list of students
	 */
	public List<Student> getAllStudent();
}
