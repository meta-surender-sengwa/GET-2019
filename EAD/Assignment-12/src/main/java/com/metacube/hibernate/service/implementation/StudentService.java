package com.metacube.hibernate.service.implementation;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.hibernate.model.Student;
import com.metacube.hibernate.repository.StudentRepository;
import com.metacube.hibernate.services.IStudentService;

/**
 * Class to implement Student Service
 * @author Surender
 */
@Service
public class StudentService implements IStudentService {

	@Autowired
	private StudentRepository repository;
	
	/**
	 * Method to add student details in the database.
	 */
	@Override
	@Transactional
	public void addStudnet(Student student) {
		repository.save(student);
	}
	
	/**
	 * Method to get students list from database.
	 */
	@Override
	@Transactional
	public List<Student> getAllStudent() {
		return (List<Student>) repository.findAll();
	}

	/**
	 * Method to return the student being searched.
	 */
	@Override
	@Transactional
	public List<Student> getStudentByName(String Key) {
		return repository.findByfirstNameContainingIgnoreCase(Key);
	}

}
