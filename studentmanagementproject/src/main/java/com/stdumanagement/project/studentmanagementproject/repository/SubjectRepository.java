package com.stdumanagement.project.studentmanagementproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.stdumanagement.project.studentmanagementproject.entity.Subject;



public interface SubjectRepository extends JpaRepository<Subject, Long>{

	List<Subject> findBySubjectDepartment(String SubjectDepartment);

	 
}
