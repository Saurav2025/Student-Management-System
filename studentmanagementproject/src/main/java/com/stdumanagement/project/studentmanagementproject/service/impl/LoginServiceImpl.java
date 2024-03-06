package com.stdumanagement.project.studentmanagementproject.service.impl;

import org.springframework.stereotype.Service;

import com.stdumanagement.project.studentmanagementproject.entity.Faculty;


import com.stdumanagement.project.studentmanagementproject.repository.LoginRepository;

import com.stdumanagement.project.studentmanagementproject.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	private LoginRepository loginRepository;

	public LoginServiceImpl(LoginRepository loginRepository) {
		super();
		this.loginRepository = loginRepository;

	}

	@Override
	public Faculty authenticateUser(String facultyGmail, String facultyPassword) {
		return loginRepository.findByFacultyGmailAndFacultyPassword(facultyGmail, facultyPassword);
	}

	@Override
	public Faculty authenticateUserId(String facultyGmail, Long id) {
		return loginRepository.findByFacultyGmailAndId(facultyGmail, id);
	}

}
