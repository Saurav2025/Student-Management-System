package com.stdumanagement.project.studentmanagementproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "subject")
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	
	//Subject subject=new Subject();
	
	
	@Column(name = "subject_department")
	private String subjectDepartment;

	@Column(name = "subject_name")
	private String subject_name;

	@Column(name = "subject_type")
	private String subject_type;

	@Column(name = "subject_grade")
	private String subject_grade;

	@Column(name = "subject_hours")
	private String subject_hours;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubjectDepartment() {
		return subjectDepartment;
	}

	public void setSubjectDepartment(String subject_department) {
		this.subjectDepartment = subject_department;
	}

	public String getSubject_name() {
		return subject_name;
	}

	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}

	public String getSubject_type() {
		return subject_type;
	}

	public void setSubject_type(String subject_type) {
		this.subject_type = subject_type;
	}

	public String getSubject_grade() {
		return subject_grade;
	}

	public void setSubject_grade(String subject_grade) {
		this.subject_grade = subject_grade;
	}

	public String getSubject_hours() {
		return subject_hours;
	}

	public void setSubject_hours(String subject_hours) {
		this.subject_hours = subject_hours;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", subject_department=" + subjectDepartment + ", subject_name=" + subject_name
				+ ", subject_type=" + subject_type + ", subject_grade=" + subject_grade + ", subject_hours="
				+ subject_hours + "]";
	}

	



}