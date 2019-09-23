package com.metacube.hibernate.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.hibernate.dao.IStudentDao;
import com.metacube.hibernate.model.Student;
import com.metacube.hibernate.service.IStudentService;

/**
 * Class implementing Student Service
 * @author Surender
 *
 */
@Service
public class StudentService implements IStudentService {

	/**
	 * Method to add student to database
	 */
	@Autowired
	private IStudentDao dao;
	
	/**
	 * Method to add student details to database
	 */
	@Override
	public void addStudnet(Student student) {
		dao.addStudnet(student);
	}
	
	/**
	 * Method to get list of students from database
	 */
	@Override
	public List<Student> getAllStudent() {
		return dao.getAllStudent();
	}
}
