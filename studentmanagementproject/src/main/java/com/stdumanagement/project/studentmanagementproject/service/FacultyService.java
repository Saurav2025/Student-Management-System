package com.stdumanagement.project.studentmanagementproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stdumanagement.project.studentmanagementproject.entity.Faculty;


@Service
public interface FacultyService {

	List<Faculty> getAllFaculties();

	Faculty saveFaculty(Faculty faculty);

	Faculty getFacultyByID(Long id);

	Faculty updateFaculty(Faculty faculty);

	void deleteFacultyById(Long id);

	boolean isSubjectAlreadyTaken(String facultySubject);
	
	//StudentSubject SubjectStudentMap(StudentSubject studentSubject);

	

}
