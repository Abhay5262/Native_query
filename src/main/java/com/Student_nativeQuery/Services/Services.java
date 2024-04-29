package com.Student_nativeQuery.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Student_nativeQuery.dto.Student_Dto;

@Service
public interface Services {
	public List<Student_Dto> getallstudent();
	public String SaveData();
	List<Student_Dto> getstudentbyrollno(Integer rollno);
	public List<Student_Dto> getstudentbylname(String rollno);
	List<Student_Dto> findUsersWithPartOfName( String fname);
	List<Student_Dto> updateuser(String fname,String lname,Integer rollno);
	
}
