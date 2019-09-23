package com.metacube.springsecurity.dao.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.metacube.springsecurity.dao.IStudentDao;
import com.metacube.springsecurity.model.Student;

/**
 * Class implementing Student DAO
 * @author Surender
 */
@Transactional
@Component
public class StudentDao implements IStudentDao{

	/**
	 * Object of Hibernate Template
	 */
	@Autowired
	HibernateTemplate sqlHandler;
	
	/**
	 * Method to add student details to database
	 */
	@Override
	public void addStudnet(Student student) {
		sqlHandler.save(student);
	}
	
	/**
	 * Method to get list of all students from database
	 */
	@Override
	public List<Student> getAllStudent() {
		return sqlHandler.loadAll(Student.class);
	}

}
