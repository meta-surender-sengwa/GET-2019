package com.metacube.springsecurity.service;

import java.util.List;

import com.metacube.springsecurity.model.Student;

/**
 * Interface for Student Service
 * @author Surender
 *
 */
public interface IStudentService {
	
	/**
	 * Method to add student details to database
	 * @param student is the student
	 */
	public void addStudnet(Student student);
	
	/**
	 * Method to get list of students from database
	 * @return
	 */
	public List<Student> getAllStudent();
}
