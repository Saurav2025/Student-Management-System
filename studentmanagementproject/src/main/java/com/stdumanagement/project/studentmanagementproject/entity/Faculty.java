package com.stdumanagement.project.studentmanagementproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "faculty")
public class Faculty {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@Column(name = "Faculty Name")
	private String faculty_Name;

	@Column(name = "Faculty Gmail")
	private String facultyGmail;

	@Column(name = "Faculty Department")
	private String faculty_department;

	@Column(name = "Faculty Subject")
	private String facultySubject;

	@Column(name = "Faculty Status")
	private String faculty_status;

	@Column(name = "Faculty Role")
	private String facultyRole;

	@Column(name = "Faculty Password")
	private String facultyPassword;

	@Column(name = "Faculty Password Status")
	private String fPasswordStatus;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFaculty_Name() {
		return faculty_Name;
	}

	public void setFaculty_Name(String faculty_Name) {
		this.faculty_Name = faculty_Name;
	}


	public String getFacultyGmail() {
		return facultyGmail;
	}


	public void setFacultyGmail(String faculty_gmail) {
		this.facultyGmail = faculty_gmail;
	}

	public String getFaculty_department() {
		return faculty_department;
	}

	public void setFaculty_department(String faculty_department) {
		this.faculty_department = faculty_department;
	}

	public String getFacultySubject() {
		return facultySubject;
	}

	public void setFacultySubject(String facultySubject) {
		this.facultySubject = facultySubject;
	}

	public String getFaculty_status() {
		return faculty_status;
	}

	public void setFaculty_status(String faculty_status) {
		this.faculty_status = faculty_status;
	}

	public String getFacultyRole() {
		return facultyRole;
	}

	public void setFacultyRole(String facultyRole) {
		this.facultyRole = facultyRole;
	}

	public String getFacultyPassword() {
		return facultyPassword;
	}

	public void setFacultyPassword(String facultyPassword) {
		this.facultyPassword = facultyPassword;
	}

	public String getfPasswordStatus() {
		return fPasswordStatus;
	}

	public void setfPasswordStatus(String fPasswordStatus) {
		this.fPasswordStatus = fPasswordStatus;
	}

	@Override
	public String toString() {
		return "Faculty [id=" + id + ", faculty_Name=" + faculty_Name + ", faculty_gmail=" + facultyGmail
				+ ", faculty_department=" + faculty_department + ", facultySubject=" + facultySubject
				+ ", faculty_status=" + faculty_status + ", facultyRole=" + facultyRole + ", facultyPassword="
				+ facultyPassword + ", fPasswordStatus=" + fPasswordStatus + "]";
	}

}
