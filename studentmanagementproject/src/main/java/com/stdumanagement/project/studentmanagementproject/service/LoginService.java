package com.stdumanagement.project.studentmanagementproject.service;


import com.stdumanagement.project.studentmanagementproject.entity.Faculty;



public interface LoginService  {
	
	Faculty authenticateUser(String facultyGmail, String facultyPassword);
	
	Faculty authenticateUserId(String facultyGmail, Long id);
}
