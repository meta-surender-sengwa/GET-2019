package com.metacube.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.metacube.hibernate.model.Search;
import com.metacube.hibernate.model.Student;
import com.metacube.hibernate.services.IStudentService;

/**
 * Controller class.
 */
@Controller
public class StudentController {

	/**
	 * 
	 */
	@Autowired
	IStudentService studentService;

	/**
	 * Setting default value for message
	 */
	@Value("${welcome.message}")
	private String message;

	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("message", message);
		return "home";
	}

	@GetMapping("/AddStudentDetailsPage")
	public String studentDetail(Model model) {
		model.addAttribute(new Student());
		return "StudentDetailForm";
	}

	@PostMapping("/AddStudentDetails")
	public String addStudentDetail(@Validated Student student, BindingResult bindingResult) {

		//	If validation error - then return to add student details jsp page
		if (bindingResult.hasErrors()) {
			return "StudentDetailForm";

		//	Else call add method of the service class
		} else {
			System.out.println(student);
			studentService.addStudent(student);
			return "redirect:/home";
		}
	}

	@GetMapping("/showStudent")
	public String showStudent(Model model) {
		List<Student> allStudent = studentService.getAllStudent();
		model.addAttribute("students", allStudent);
		return "showStudent";
	}

	@GetMapping("/SearchStudentPage")
	public String searchStudent(Model model) {
		model.addAttribute(new Search());
		return "searchStudent";
	}

	@GetMapping("/SearchStudent")
	public String doSearch(@Validated Search search, BindingResult bindingResult, Model model) {

		//	If validation error - then return to search student jsp page
		if (bindingResult.hasErrors()) {
			return "searchStudent";
			
		//	Else search student based on the first name 
		} else {
			List<Student> student = studentService.getStudentByName(search.getFirstName());
			model.addAttribute("students", student);
			return "/showStudent";
		}
	}
}
