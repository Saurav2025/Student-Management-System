package com.stdumanagement.project.studentmanagementproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stdumanagement.project.studentmanagementproject.entity.Faculty;
import com.stdumanagement.project.studentmanagementproject.service.LoginService;

import jakarta.servlet.http.HttpSession;

@Controller
public class loginController {

	private LoginService loginService;

	public loginController(LoginService loginService) {
		super();
		this.loginService = loginService;

	}

	@GetMapping("/login")
	public String showLoginPage(HttpSession session) {
		return "login";

	}

	@PostMapping("/login")
	public String faculty(@RequestParam String facultyGmail, HttpSession session, Model model,
			@RequestParam String facultyPassword) {

		Faculty user = loginService.authenticateUser(facultyGmail, facultyPassword);

		if (user != null) {
			session.setAttribute("userId", user.getId());
			session.setAttribute("username", user.getFacultyGmail());
			session.setAttribute("role", user.getFacultyRole());
			session.setAttribute("name", user.getFaculty_Name());
			session.setAttribute("department", user.getFaculty_department());
			session.setAttribute("subject", user.getFacultySubject());
			

			if ("Faculty".equals(user.getFacultyRole())) {
				return "redirect:/facultyRole"; // Redirect to faculty page
			} else {
				return "redirect:/students"; // Redirect to students page
			}

		} else {
			model.addAttribute("error", "Invalid username or password");
			return "login";
		}

	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate(); // Invalidate the session
		return "redirect:/login";
	}

}
