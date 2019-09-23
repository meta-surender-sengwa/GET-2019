package com.metacube.springsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.metacube.springsecurity.model.Student;
import com.metacube.springsecurity.service.IStudentService;

/**
 * Controller class.
 */
@Controller
public class StudentController {

	@Autowired
	IStudentService studentServics;

	@Value("${welcome.message}")
	private String message;

	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("message", message);
		return "home";
	}

	@GetMapping("/AddStudentDetails")
	public String studentDetail(Model model) {
		model.addAttribute(new Student());
		return "StudentDetailForm";
	}

	@PostMapping("/AddStudentDetails")
	public String addStudentDetail(@Validated Student student, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "StudentDetailForm";

		} else {
			System.out.println(student);
			studentServics.addStudnet(student);
			return "redirect:/home";
		}
	}

	@GetMapping("/showStudent")
	public String showStudent(Model model) {

		List<Student> allStudent = studentServics.getAllStudent();
		model.addAttribute("students", allStudent);
		return "showStudent";
	}

	@GetMapping("/login")

	public String login(@RequestParam(value = "error", required = false) String error, Model model) {
		
		if (error != null) {
			model.addAttribute("errorMsg", "Authentication Failed");
		}

		return "login";
	}
}
