package com.stdumanagement.project.studentmanagementproject.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stdumanagement.project.studentmanagementproject.entity.Faculty;
import com.stdumanagement.project.studentmanagementproject.entity.Student;
import com.stdumanagement.project.studentmanagementproject.entity.StudentSubject;
import com.stdumanagement.project.studentmanagementproject.service.FacultyService;
import com.stdumanagement.project.studentmanagementproject.service.StudentService;

import jakarta.servlet.http.HttpSession;

@Controller
public class FacultyController {

	private FacultyService facultyService;
	private StudentService studentService;

	public FacultyController(FacultyService facultyService, StudentService studentService) {
		super();
		this.facultyService = facultyService;
		this.studentService = studentService;

	}

	@GetMapping("/faculties")
	public String ListFaculty(Model model, HttpSession session) {

		if (session.getAttribute("userId") == null || session.getAttribute("username") == null
				|| session.getAttribute("role") == null) {

			return "redirect:/login";
		}
		model.addAttribute("faculty", facultyService.getAllFaculties());
		return "faculty";
	}

	@GetMapping("/facultyRole")
	public String ListFacultyRole(Model model, HttpSession session) {

		if (session.getAttribute("userId") == null || session.getAttribute("username") == null
				|| session.getAttribute("role") == null) {

			return "redirect:/login";
		}
		model.addAttribute("faculty", facultyService.getAllFaculties());
		return "facultyList";
	}

	@GetMapping("/faculty/new")
	public String createFacultyForm(Model model) {
		Faculty faculty = new Faculty();
		model.addAttribute("faculty", faculty);
		return "create_faculty";
	}

	@PostMapping("/facultySave")
	public String saveFaculty(@ModelAttribute("faculty") Faculty faculty, Model model) {

		boolean isSubjectAlreadyTaken = facultyService.isSubjectAlreadyTaken(faculty.getFacultySubject());

		if (isSubjectAlreadyTaken) {
			// If subject is already taken, add an error message to the model
			model.addAttribute("error", "Subject already taken by another faculty. Please select another subject.");
			return "create_faculty"; // Return to the create faculty form with the error message
		} else {
			// If subject is not already taken, save the faculty
			facultyService.saveFaculty(faculty);
			return "redirect:/faculties";
		}

	}

	@GetMapping("/faculty/{id}")
	public String deletefaculty(@PathVariable Long id) {
		facultyService.deleteFacultyById(id);
		return "redirect:/faculties";
	}

	@GetMapping("/changePassword")
	public String changePassword(HttpSession session) {

		return "redirect:/login";
	}

	@GetMapping("/faculty/edit/{id}")
	public String updateFaculty(Model model, @PathVariable Long id) {
		model.addAttribute("faculty", facultyService.getFacultyByID(id));
		return "edit_faculty";
	}

	@PostMapping("/faculty/{id}")
	public String updateFacultyForm(@PathVariable Long id, Model model, @ModelAttribute("faculty") Faculty faculty) {

		Faculty existingFaculty = facultyService.getFacultyByID(id);

		existingFaculty.setId(19900 + faculty.getId());
		existingFaculty.setFaculty_department(faculty.getFaculty_department());
		existingFaculty.setFaculty_Name(faculty.getFaculty_Name());
		existingFaculty.setFacultyGmail(faculty.getFacultyGmail());
		existingFaculty.setFacultySubject(faculty.getFacultySubject());
		existingFaculty.setFaculty_status(faculty.getFaculty_status());
		existingFaculty.setFacultyRole(faculty.getFacultyRole());

		facultyService.saveFaculty(existingFaculty);

		return "redirect:/faculties";
	}

	@GetMapping("/faculty/passedit/{id}")
	public String updateFacultyPassword(Model model, @PathVariable Long id) {
		model.addAttribute("faculty", facultyService.getFacultyByID(id));
		return "edit_facultyPassword";
	}

	@PostMapping("/passedit/{id}")
	public String updateFacultyPasswordForm(@PathVariable Long id, Model model,
			@RequestParam("password") String password, @RequestParam("confirmPassword") String confirmPassword,
			@ModelAttribute("faculty") Faculty faculty, HttpSession session) {

		if (!password.equals(confirmPassword)) {
			model.addAttribute("error", true);
			return "edit_facultyPassword";
		}

		Faculty existingFaculty = facultyService.getFacultyByID(id);
		existingFaculty.setFacultyPassword(password);
		facultyService.saveFaculty(existingFaculty);

		if (session.getAttribute("role").equals("Admin")) {
			return "redirect:/faculties";
		} else {
			return "redirect:/studentMapping";
		}

	}

	@GetMapping("/studentMapping")
	public String createFacultyStudentMapping(Model model, HttpSession session) {
		if (session.getAttribute("userId") == null || session.getAttribute("username") == null
				|| session.getAttribute("role") == null) {

			return "redirect:/login";
		}

		String department = (String) session.getAttribute("department");
		List<Student> students = studentService.getStudentsByDepartment(department);

		List<Long> mappedStudentIds = studentService.getMappedStudentIds();
		List<Long> studentIds = students.stream().map(Student::getId).collect(Collectors.toList());
		List<Long> errorStudentIds = studentIds.stream().filter(mappedStudentIds::contains)
				.collect(Collectors.toList());
		model.addAttribute("students", students);
		model.addAttribute("errorStudentIds", errorStudentIds);
		model.addAttribute("faculty", facultyService.getAllFaculties());

		return "facultyStudentMapping";
	}

	@GetMapping("/studentMapSubject/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));

		return "facultyStudentSubMap";
	}

	@PostMapping("/studSubMap/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("studentSubject") StudentSubject studentSubject,
			Model model, @RequestParam("email") String email, @RequestParam("fullName") String fullName,
			@RequestParam("subject") String subject, @RequestParam("department") String department,
			HttpSession session) {

		// Get STudent from database
		StudentSubject newStudent = new StudentSubject();
		String facultyMail = (String) session.getAttribute("username");
		String facultyName = (String) session.getAttribute("name");
		Long facultyId = (Long) session.getAttribute("userId");

		newStudent.setFacultMail(facultyMail);
		newStudent.setFacultName(facultyName);
		newStudent.setFacultyId(facultyId);
		newStudent.setStudentDepartment(department);

		newStudent.setStudentId(id);
		newStudent.setStudentMail(email);
		newStudent.setStudentName(fullName);
		newStudent.setStudentSubject(subject);
		
		newStudent.setMarkStatus(0L);

		studentService.updateStudentSubject(newStudent);

		return "redirect:/studentMapping";

	}

	@GetMapping("/SubjectMark")
	public String SubjectMarkForm(HttpSession session, Model model) {

		model.addAttribute("studentsubject", studentService.getAllStudentSubject());
		
		

		if (session.getAttribute("role").equals("Admin")) {
			return "SubjectMarkAdmin";
		} else {
			return "SubjectMark";
		}
		
	}

	@GetMapping("/studentMark/edit/{id}")
	public String uploadStudentMarks(Model model, @PathVariable Long id) {
		model.addAttribute("studentsubject", studentService.getStudentSubjectById(id));
		return "upload_marks";
	}

	@PostMapping("/studentMark/{id}")
	public String uploadStudentMarksSheet(@PathVariable Long id, Model model,
			@ModelAttribute("studentsubject") StudentSubject studentSubject) {

		StudentSubject existingStudent = studentService.getStudentSubjectById(id);
		existingStudent.setFirstInternal(studentSubject.getFirstInternal());
		existingStudent.setSecondInternal(studentSubject.getSecondInternal());
		existingStudent.setFinalExam(studentSubject.getFinalExam());
		existingStudent.setMarkStatus(0L);
		studentService.updateStudentSubject(existingStudent);
		return "redirect:/SubjectMark";
	}

	// Handle method to handle delete student request
	@GetMapping("/studentMarkFinalize/{id}")
	public String studentMarkFinalize(@PathVariable Long id, Model model,
			@ModelAttribute("studentsubject") StudentSubject studentSubject) {
		
		
		StudentSubject existingStudent = studentService.getStudentSubjectById(id);
		
		existingStudent.setMarkStatus(1L);
		studentService.updateStudentSubject(existingStudent);
		return "redirect:/SubjectMark";
	}
	
	@GetMapping("/AdminReEditMark/{id}")
	public String AdminReEditMark(@PathVariable Long id, Model model,
			@ModelAttribute("studentsubject") StudentSubject studentSubject) {
		
		
		StudentSubject existingStudent = studentService.getStudentSubjectById(id);
		
		existingStudent.setMarkStatus(0L);
		studentService.updateStudentSubject(existingStudent);
		return "redirect:/SubjectMark";
	}

}
