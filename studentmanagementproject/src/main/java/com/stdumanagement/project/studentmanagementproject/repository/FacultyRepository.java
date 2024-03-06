package com.stdumanagement.project.studentmanagementproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stdumanagement.project.studentmanagementproject.entity.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {

	boolean existsByFacultySubject(String facultySubject);

	
}
