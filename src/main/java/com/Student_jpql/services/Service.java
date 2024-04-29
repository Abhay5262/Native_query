package com.Student_jpql.services;

import java.util.List;
import java.util.Optional;

import com.Student_jpql.Dto.Student_dto;

@org.springframework.stereotype.Service

public interface Service {

	public List<Student_dto> getallstudent();
	public String savestudent(Student_dto student);
	public Optional<Student_dto> getstudentbyid(String rollno);
	public String deletebyid(String rollno);
	public String deleteall();
	public List<Student_dto> findUsersWithAddress();
}
