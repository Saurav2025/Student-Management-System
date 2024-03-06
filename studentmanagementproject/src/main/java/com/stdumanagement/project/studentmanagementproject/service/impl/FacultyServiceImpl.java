package com.stdumanagement.project.studentmanagementproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stdumanagement.project.studentmanagementproject.entity.Faculty;

import com.stdumanagement.project.studentmanagementproject.repository.FacultyRepository;
import com.stdumanagement.project.studentmanagementproject.service.FacultyService;

@Service
public class FacultyServiceImpl implements FacultyService {

	@Autowired
	private FacultyRepository facultyRepository;
	
	

	public FacultyServiceImpl(FacultyRepository facultyRepository) {
		super();
		this.facultyRepository = facultyRepository;

	}

	@Override
	public List<Faculty> getAllFaculties() {
		return facultyRepository.findAll();
	}

	@Override
	public Faculty saveFaculty(Faculty faculty) {
		return facultyRepository.save(faculty);
	}

	@Override
	public Faculty getFacultyByID(Long id) {
		return facultyRepository.findById(id).get();
	}

	@Override
	public Faculty updateFaculty(Faculty faculty) {
		return facultyRepository.save(faculty);
	}

	@Override
	public void deleteFacultyById(Long id) {
		facultyRepository.deleteById(id);
	}
	
	@Override
	public boolean isSubjectAlreadyTaken(String subject) {
        // Check if any faculty is already mapped to the given subject
        return facultyRepository.existsByFacultySubject(subject);
    }
	
//	public StudentSubject SubjectStudentMap(StudentSubject studentSubject)
//	{
//		
//	}

	
	

}
