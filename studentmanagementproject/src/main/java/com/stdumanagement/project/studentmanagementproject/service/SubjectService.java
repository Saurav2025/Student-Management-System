package com.stdumanagement.project.studentmanagementproject.service;

import java.util.List;

import com.stdumanagement.project.studentmanagementproject.entity.Subject;

public interface SubjectService {

	List<Subject> getAllSubject();

	Subject saveSubject(Subject subject);

	Subject getSubjectById(Long id);

	Subject updateSubject(Subject subject);
	
	void deleteSubject(Long id);
 
	List<String> getSubjectsByDepartment(String SubjectDepartment);
	
		  

}
