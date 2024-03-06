package com.stdumanagement.project.studentmanagementproject.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stdumanagement.project.studentmanagementproject.entity.Subject;
import com.stdumanagement.project.studentmanagementproject.service.SubjectService;

import jakarta.servlet.http.HttpSession;

@Controller
public class SubjectController {

	private SubjectService subjectService;

	public SubjectController(SubjectService subjectService) {
		super();
		this.subjectService = subjectService;
	}

	@GetMapping("/subjects")

	public String listSubject(Model model, HttpSession session) {

		if (session.getAttribute("userId") == null || session.getAttribute("username") == null
				|| session.getAttribute("role") == null) {
			// Redirect to login page if session attributes are not set
			return "redirect:/login";
		}
		// Proceed to return the view normally
		model.addAttribute("subject", subjectService.getAllSubject());
		return "subject";
	}

	@GetMapping("/subject/new")
	public String createSubjectForm(Model model) {
		// create student object to hold student from data
		Subject subject = new Subject();
		model.addAttribute("subject", subject);
		return "create_subject";
	}

	@PostMapping("/subjectSave")
	public String saveSubject(@ModelAttribute("subject") Subject subject) {
		subjectService.saveSubject(subject);
		return "redirect:/subjects";
	}

	@GetMapping("/subject/{id}")
	public String deleteSubjectById(@PathVariable Long id) {
		subjectService.deleteSubject(id);
		return "redirect:/subjects";
	}

	@GetMapping("/subject/edit/{id}")
	public String updateSubjectForm(@PathVariable Long id, Model model) {
		model.addAttribute("subject", subjectService.getSubjectById(id));
		return "edit_subject";
	}

	@PostMapping("/subject/{id}")
	public String updateSubjectForm(@PathVariable Long id, @ModelAttribute("subject") Subject subject, Model model) {
		Subject existingSubject = subjectService.getSubjectById(id);
		existingSubject.setId(subject.getId());
		existingSubject.setSubjectDepartment(subject.getSubjectDepartment());
		existingSubject.setSubject_grade(subject.getSubject_grade());
		existingSubject.setSubject_hours(subject.getSubject_hours());
		existingSubject.setSubject_name(subject.getSubject_name());
		existingSubject.setSubject_type(subject.getSubject_type());

		subjectService.updateSubject(existingSubject);

		return "redirect:/subjects";
	}

	@GetMapping("/fetchSubjects")
	@ResponseBody
	public List<String> fetchSubjects(@RequestParam String SubjectDepartment) {
		return subjectService.getSubjectsByDepartment(SubjectDepartment);
	}

}
