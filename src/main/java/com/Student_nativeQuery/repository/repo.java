package com.Student_nativeQuery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.Student_nativeQuery.Entity.Student_Entity;

public interface repo extends JpaRepository<Student_Entity, Long> {
	
	@Query("SELECT s from Student_Entity s")
	List<Student_Entity> getallstudent();
	
	@Query(value = "SELECT * from student_entity WHERE rollno=:rollno",nativeQuery = true)
	List<Student_Entity> getstudentbyrollno(@Param("rollno") Integer rollno) ;

	@Query(value = "SELECT * from student_entity WHERE lname=:lname",nativeQuery = true)
	List<Student_Entity> getstudentbylname(@Param("lname")String lname);
	
	@Query(value = "SELECT * FROM student_entity WHERE fname like CONCAT(?1,'%')",nativeQuery=true)
	List<Student_Entity> findUsersWithPartOfName(@Param("fname") String fname);
	
	@Query(value = "Update student_entity WHERE fname=?1,lname=?2,rollno=?3",nativeQuery = true)
	@Modifying
	@Transactional
	List<Student_Entity>updateuser(@Param("fname") String fname,@Param("lname") String lname,@Param("rollno") Integer rollno);

	
	
	
}
