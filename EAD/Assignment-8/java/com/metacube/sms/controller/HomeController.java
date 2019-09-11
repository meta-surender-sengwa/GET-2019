package com.metacube.sms.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.metacube.sms.model.AllStudent;
import com.metacube.sms.model.Student;

@Controller
public class HomeController {

	private static final Logger log = LoggerFactory.getLogger(Student.class);

	@Value("${welcome.message}")
	private String welcomeMessage;

	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("welcomeMessage", welcomeMessage);
		return "home";
	}

	@GetMapping("/AddStudentDetails")
	public String addStudentDetails(Model model) {
		model.addAttribute(new Student());
		return "AddStudentDetails";
	}

	@PostMapping("/AddStudentDetails")
	public String addStudentDetails(@Validated Student student, BindingResult result) {
		if (result.hasErrors()) {
			return "AddStudentDetails";
			
		} else {
			log.info("First Name : " + student.getFirstName());
			log.info("Last Name : " + student.getLastName());
			log.info("Father Name : " + student.getFatherName());
			log.info("Email Id : " + student.getEmail());
			log.info("Student Class : " + student.getStudentClass());
			log.info("Student Age : " + student.getAge());

			return "redirect:/home";
		}
	}

	@GetMapping("/ShowStudentDetails")
	public String showStudentDetails(Model model) {

		ArrayList<Student> list = new ArrayList<Student>();
		list = AllStudent.getStudent();
		
		model.addAttribute("student1", list);

		return "ShowStudentDetails";
	}

}
