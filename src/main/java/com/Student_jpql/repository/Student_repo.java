package com.Student_jpql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Student_jpql.Entity.Student_Entity;
@Repository
@EnableJpaRepositories
public interface Student_repo extends CrudRepository<Student_Entity, Long> {

	@Query("SELECT s from Student_Entity s")
	List<Student_Entity> getallstudent();
	
	@Query("SELECT s from Student_Entity s WHERE s.rollno=:rollno")
	Student_Entity getstudentbyid(@Param("rollno") String rollno) ;
	
	@Modifying
	@Transactional
	@Query("DELETE from Student_Entity d  WHERE d.rollno=:rollno")
	 void deletebyid(@Param("rollno") String rollno);
	
	@Modifying
	@Transactional
	@Query("SELECT u from Student_Entity u WHERE u.addres LIKE'r%'")
	List<Student_Entity> findUsersWithAddress();


}
