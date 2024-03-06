package com.stdumanagement.project.studentmanagementproject.service.impl;

import java.util.ArrayList;
import java.util.List;


import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.stdumanagement.project.studentmanagementproject.entity.Subject;
import com.stdumanagement.project.studentmanagementproject.repository.SubjectRepository;
import com.stdumanagement.project.studentmanagementproject.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {

	private SubjectRepository subjectRepository;

	public SubjectServiceImpl(SubjectRepository subjectRepository) {
		super();
		this.subjectRepository = subjectRepository;
	}

	@Override
	public List<Subject> getAllSubject() {
		return subjectRepository.findAll();
	}

	@Override
	public Subject saveSubject(Subject subject) {
		return subjectRepository.save(subject);
	}

	@Override
	public Subject getSubjectById(Long id) {
		return subjectRepository.findById(id).get();
	}

	@Override
	public Subject updateSubject(Subject subject) {
		return subjectRepository.save(subject);
	}

	@Override
	public void deleteSubject(Long id) {
		subjectRepository.deleteById(id);
	}

	public List<Subject> getSubjectByDepartment(Sort department)
	{
		return subjectRepository.findAll(department);
	}
	
	public List<String> getSubjectsByDepartment(String department) {
	    List<Subject> subjects = subjectRepository.findBySubjectDepartment(department);
	    List<String> subjectNames = new ArrayList<>();

	    for (Subject subject : subjects) {
	        subjectNames.add(subject.getSubject_name());
	    }

	    return subjectNames;
	}
}
