package com.stdumanagement.project.studentmanagementproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.stdumanagement.project.studentmanagementproject.entity.Student;
import com.stdumanagement.project.studentmanagementproject.service.StudentService;

import jakarta.servlet.http.HttpSession;


@Controller
public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	// To handle list and return mode and view

	@GetMapping("/students")
	public String listStudent(Model model, HttpSession session) {

		if (session.getAttribute("userId") == null || session.getAttribute("username") == null
				|| session.getAttribute("role") == null) {
			// Redirect to login page if session attributes are not set
			return "redirect:/login";
		}

		model.addAttribute("students", studentService.getAllStudents());
		return "students";

	}
	
	@GetMapping("/students/about")
	public String About(Model model, HttpSession session) {
		if (session.getAttribute("userId") == null || session.getAttribute("username") == null
				|| session.getAttribute("role") == null) {

			return "redirect:/login";
		}
		model.addAttribute("students", studentService.getAllStudents());
		return "About";
	}

	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		// create student object to hold student from data
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}

	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";

	}

	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
	}

	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {

		// Get STudent from database
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(student.getId());
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		existingStudent.setF_name(student.getF_name());
		existingStudent.setMark(student.getMark());
		existingStudent.setDepartment(student.getDepartment());

		// Save updated student object

		studentService.updateStudent(existingStudent);
		return "redirect:/students";
	}


	
	
	// Handle method to handle delete student request
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		
		studentService.deleteStudentId(id);
		return "redirect:/students";
	}

}
