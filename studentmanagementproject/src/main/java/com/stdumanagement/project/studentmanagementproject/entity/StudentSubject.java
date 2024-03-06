package com.stdumanagement.project.studentmanagementproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "studentSubject")
public class StudentSubject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "studentId")
	private Long studentId;

	@Column(name = "studentName")
	private String studentName;

	@Column(name = "studentMail")
	private String studentMail;

	@Column(name = "studentDepartment")
	private String studentDepartment;

	@Column(name = "studentSubject")
	private String studentSubject;

	@Column(name = "facultyId")
	private Long facultyId;

	@Column(name = "facultMail")
	private String facultMail;

	@Column(name = "facultName")
	private String facultName;
	
	@Column(name = "firstInternal")
	private String firstInternal;
	
	@Column(name = "secondInternal")
	private String secondInternal;
	
	@Column(name = "finalExam")
	private String finalExam;
	
	@Column(name = "markStatus")
	private Long markStatus;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentMail() {
		return studentMail;
	}

	public void setStudentMail(String studentMail) {
		this.studentMail = studentMail;
	}

	public String getStudentDepartment() {
		return studentDepartment;
	}

	public void setStudentDepartment(String studentDepartment) {
		this.studentDepartment = studentDepartment;
	}

	public String getStudentSubject() {
		return studentSubject;
	}

	public void setStudentSubject(String studentSubject) {
		this.studentSubject = studentSubject;
	}

	public Long getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(Long facultyId) {
		this.facultyId = facultyId;
	}

	public String getFacultMail() {
		return facultMail;
	}

	public void setFacultMail(String facultMail) {
		this.facultMail = facultMail;
	}

	public String getFacultName() {
		return facultName;
	}

	public void setFacultName(String facultName) {
		this.facultName = facultName;
	}

	public String getFirstInternal() {
		return firstInternal;
	}

	public void setFirstInternal(String firstInternal) {
		this.firstInternal = firstInternal;
	}

	public String getSecondInternal() {
		return secondInternal;
	}

	public void setSecondInternal(String secondInternal) {
		this.secondInternal = secondInternal;
	}

	public String getFinalExam() {
		return finalExam;
	}

	public void setFinalExam(String finalExam) {
		this.finalExam = finalExam;
	}

	public Long getMarkStatus() {
		return markStatus;
	}

	public void setMarkStatus(Long markStatus) {
		this.markStatus = markStatus;
	}

	@Override
	public String toString() {
		return "StudentSubject [id=" + id + ", studentId=" + studentId + ", studentName=" + studentName
				+ ", studentMail=" + studentMail + ", studentDepartment=" + studentDepartment + ", studentSubject="
				+ studentSubject + ", facultyId=" + facultyId + ", facultMail=" + facultMail + ", facultName="
				+ facultName + ", firstInternal=" + firstInternal + ", secondInternal=" + secondInternal
				+ ", finalExam=" + finalExam + ", markStatus=" + markStatus + "]";
	}

	

	
	
}
