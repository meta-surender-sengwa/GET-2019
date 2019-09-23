package com.metacube.hibernate.service;

import java.util.List;
import com.metacube.hibernate.model.Student;

/**
 * Interface of service layer
 * @author Surender
 */
public interface IStudentService {

	/**
	 * Method to add student in the database.
	 * @param student is object of model class
	 */
	public void addStudnet(Student student);
	
	/**
	 * Method to get student list from database.
	 * @return list of students
	 */
	public List<Student> getAllStudent();
	
	/**
	 * Method to return the student which name equal to key.
	 * @param Key is the key(name) used for searching
	 * @return the student details
	 */
	public List<Student> getStudentByName(String Key);
}
