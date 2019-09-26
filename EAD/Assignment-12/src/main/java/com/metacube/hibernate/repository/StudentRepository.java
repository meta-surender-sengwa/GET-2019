package com.metacube.hibernate.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.metacube.hibernate.model.Student;

/**
 * Repository interface
 * @author Surender
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

	/**
	 * Method to return the student which name equal to key.
	 * @param key is the student's name to be searched
	 * @return the details of the student 
	 */
	public List<Student> findByfirstNameContainingIgnoreCase(String firstName);
}
