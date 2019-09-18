package com.metacube.parking.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.metacube.parking.model.Employee;
import com.metacube.parking.model.EmployeeLogin;
import com.metacube.parking.model.Pass;
import com.metacube.parking.model.VehicleDetails;

@Controller()
public class MetaParkingController {
	List<Employee> emplist = new ArrayList<Employee>();
	List<EmployeeLogin> login = new ArrayList<EmployeeLogin>();
	List<VehicleDetails> vehicleDetails = new ArrayList<VehicleDetails>();
	Integer[] passPrices = null;

	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("employeeLogin", new EmployeeLogin());
		return "homepage";
	}

	@PostMapping("/home")
	public String doLogin( @Valid @ModelAttribute("employeeLogin") EmployeeLogin employeeLogin, BindingResult bindingResult ,RedirectAttributes attributes, HttpServletRequest request) {
		
		if (bindingResult.hasErrors()) {
			return "homepage";
			
		} else {
			login.add(employeeLogin);
			HttpSession session = request.getSession();
			session.setAttribute("email", employeeLogin.getEmail());
			attributes.addFlashAttribute("loggedMsg", "Logged in successfully");
			return "redirect:/showProfile";
		}
	}

	@GetMapping("/signUp")
	public String signUp(Model model) {
		model.addAttribute("employee", new Employee());
		return "signUp";
	}

	@PostMapping("/signUp")
	public String doSignup(@Valid @ModelAttribute("employee") Employee employee, BindingResult result) {
		
		if (result.hasErrors()) {
			return "signUp";
		
		} else if (!(employee.getPassword().equals(employee.getConfirmPassword()))){
			ObjectError error = new ObjectError("errorMsg", "Password and confirm password should be same");
			result.addError(error);
			return "signUp";
			
		} else {
			emplist.add(employee);
			return "redirect:/vehicleRegistration";
		}
	}

	@GetMapping("/vehicleRegistration")
	public String register(Model model) {
		model.addAttribute("vehicle", new VehicleDetails());
		return "vehicleRegistration";
	}

	@PostMapping("/vehicleRegistration")
	public String vehicleRegister(@Valid @ModelAttribute("vehicle") VehicleDetails vehicle, BindingResult result, RedirectAttributes attribute) {
		
		if (result.hasErrors()) {
			return "vehicleRegistration";
		
		} else {
			vehicleDetails.add(vehicle);
			attribute.addAttribute("type", vehicle.getVehicleType());
			return "redirect:/getPass";
		}
	}

	@GetMapping("/getPass")
	public String getPass(@RequestParam("type") String type, Model model) {
		
		if ("cycle".equals(type)) {
			passPrices = new Integer[] { 5, 100, 500 };
		
		} else if ("bike".equals(type)) {
			passPrices = new Integer[] { 10, 200, 1000 };
		
		} else if ("car".equals(type)) {
			passPrices = new Integer[] { 20, 500, 3500 };
		}
		
		Map<Integer, String> passMap = new HashMap<Integer, String>();
		passMap.put(passPrices[0], passPrices[0] + "Daily");
		passMap.put(passPrices[1], passPrices[1] + "Monthly");
		passMap.put(passPrices[2], passPrices[2] + "Yearly");
		model.addAttribute("passPrices", passMap);
		model.addAttribute("pass", new Pass());
		return "getPass";
	}

	@PostMapping("/getPass")
	public String getFinalPass(@Validated Pass pass, BindingResult result, RedirectAttributes reAttribute) {
		
		double plan = Double.parseDouble(pass.getPlan());
		String currency = pass.getCurrency();
		
		if ("YEN".equals(currency)) {
			plan = plan * 1.49;
		
		} else if ("USD".equals(currency)) {
			plan = plan * 0.014;
		}
		
		reAttribute.addAttribute("passPrice", plan);
		return "redirect:/pass";
	}

	@GetMapping("/showProfile")
	public String showStudent(Model model) {
		model.addAttribute("emplist", emplist);
		return "showProfile";
	}

	@PostMapping("/showProfile")
	public String update(Model model, Employee emp) {
		return "redirect:/update";
	}

	@GetMapping("/update")
	public String update(Model model) {
		model.addAttribute("emplist", emplist);
		return "update";
	}

	@PostMapping("/update")
	public String updateEmployee(@Validated Employee employee, BindingResult result, RedirectAttributes attributes) {
		
		if (result.hasErrors()) {
			return "update";
		
		} else {
		
			if (!(employee.getPassword().equals(employee.getConfirmPassword()))) {
				ObjectError error = new ObjectError("errorMsg",
						"Password and confirm password should be same");
				result.addError(error);
			}
			
			for (Employee emp : emplist) {
				
				if (emp.getEmail().equals(employee.getEmail())) {
					emp.setFullname(employee.getFullname());
					emp.setContact(employee.getContact());
					emp.setGender(employee.getGender());
					emp.setOrganisation(employee.getOrganisation());
					emp.setEmail(employee.getEmail());
					emp.setPassword(employee.getPassword());
					emp.setConfirmPassword(employee.getConfirmPassword());
				}
			}
			return "home";
		}
	}

	@GetMapping("/pass")
	public String pass(@RequestParam("passPrice") double passPrice, Model model) {
		model.addAttribute("passPrice", passPrice);
		return "pass";
	}

	@GetMapping("/friends")
	public String friends(@RequestParam("email") String email, Model model) {
		
		List<Employee> friends = new ArrayList<Employee>();
		String organization = null;
		
		for (Employee e : emplist) {
		
			if (e.getEmail().equals(email)) {
				organization = e.getOrganisation();
			}
		}

		for (Employee e : emplist) {
		
			if (e.getOrganisation().equals(organization)
					&& (!e.getEmail().equals(email))) {
				friends.add(e);
			}
		}
		model.addAttribute("friends", friends);
		return "friends";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		session.removeAttribute("email");
		return "redirect:/home";
	}
}
