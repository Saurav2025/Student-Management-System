package com.stdumanagement.project.studentmanagementproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.stdumanagement.project.studentmanagementproject.entity.*;

public interface StudentRepository extends JpaRepository<Student, Long> {
	List<Student> findByDepartment(String department);

}
