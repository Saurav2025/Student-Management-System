package com.stdumanagement.project.studentmanagementproject.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.stdumanagement.project.studentmanagementproject.entity.StudentSubject;

public interface StudentSubjectMapp extends JpaRepository<StudentSubject, Long> {

	boolean existsByStudentId(Long studentId);
	
	                     
	
    @Modifying
    @Transactional
    @Query("DELETE FROM StudentSubject ss WHERE ss.studentId = :studentId")
    void deleteByStudentId(@Param("studentId") Long studentId);

	
}
     