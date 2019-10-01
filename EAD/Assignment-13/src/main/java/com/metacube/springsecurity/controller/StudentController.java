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

import com.metacube.springsecurity.service.IStudentService;
import com.metacube.springsecurity.model.Student;

/**
 * Controller class
 * @author Surender
 */
@Controller
public class StudentController {

	@Autowired
	IStudentService studentService;

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
			studentService.addStudnet(student);
			return "redirect:/home";
		}
	}

	@GetMapping("/showStudent")
	public String showStudent(Model model) {

		List<Student> allStudent = studentService.getAllStudent();
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
