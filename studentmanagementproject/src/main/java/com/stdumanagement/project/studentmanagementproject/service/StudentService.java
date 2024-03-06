package com.stdumanagement.project.studentmanagementproject.service;

import java.util.List;

import com.stdumanagement.project.studentmanagementproject.entity.Student;
import com.stdumanagement.project.studentmanagementproject.entity.StudentSubject;

public interface StudentService {

	List<Student> getAllStudents();

	Student saveStudent(Student student);

	Student getStudentById(Long id);

	Student updateStudent(Student student);
	
	void deleteStudentById(Long id);
	
	List<Student> getStudentsByDepartment(String department);
	
	StudentSubject updateStudentSubject(StudentSubject studentSubject);
	
	StudentSubject getStudentSubjectById(Long id);
	
	List<Long> getMappedStudentIds();
	
	List<StudentSubject> getAllStudentSubject();
	
	
	void deleteStudentId(Long studentId);

}
