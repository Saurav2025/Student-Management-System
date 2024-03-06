package com.stdumanagement.project.studentmanagementproject.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stdumanagement.project.studentmanagementproject.entity.Student;
import com.stdumanagement.project.studentmanagementproject.entity.StudentSubject;
import com.stdumanagement.project.studentmanagementproject.repository.StudentRepository;
import com.stdumanagement.project.studentmanagementproject.repository.StudentSubjectMapp;
import com.stdumanagement.project.studentmanagementproject.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private StudentSubjectMapp studentSubjectMapp;

	public StudentServiceImpl(StudentRepository studentRepository,StudentSubjectMapp studentSubjectMapp) {
		super();
		this.studentRepository = studentRepository;
		this.studentSubjectMapp=studentSubjectMapp;
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id);
	}
	
	public List<Student> getStudentsByDepartment(String department) {
	    return studentRepository.findByDepartment(department);
	}

	@Override
	public StudentSubject updateStudentSubject(StudentSubject studentSubject) {
		return studentSubjectMapp.save(studentSubject);
	}
	
	@Override
	public StudentSubject getStudentSubjectById(Long id) {
		return studentSubjectMapp.findById(id).get();
	}
	public List<Long> getMappedStudentIds() {
        List<StudentSubject> mappedStudents = studentSubjectMapp.findAll();
        return mappedStudents.stream()
            .map(StudentSubject::getStudentId)
            .collect(Collectors.toList());
    }
	
	public 	List<StudentSubject> getAllStudentSubject()
	{
		return studentSubjectMapp.findAll();
	}
	
	public void deleteStudentId(Long studentId) {
        studentSubjectMapp.deleteByStudentId(studentId);
    }

	
	
}
