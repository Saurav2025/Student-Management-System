package com.stdumanagement.project.studentmanagementproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stdumanagement.project.studentmanagementproject.entity.Faculty;



public interface LoginRepository extends JpaRepository<Faculty, Long> {

	Faculty findByFacultyGmailAndFacultyPassword(String facultyGmail, String facultyPassword);

	Faculty findByFacultyGmailAndId(String facultyGmail, Long id);
	
}
