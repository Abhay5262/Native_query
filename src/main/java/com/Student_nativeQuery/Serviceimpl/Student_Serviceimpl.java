package com.Student_nativeQuery.Serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Student_nativeQuery.Entity.Student_Entity;
import com.Student_nativeQuery.Services.Services;
import com.Student_nativeQuery.dto.Student_Dto;
import com.Student_nativeQuery.repository.repo;
import com.Student_nativeQuery.utils.Helper;
import com.github.javafaker.Faker;
@Component
public class Student_Serviceimpl implements Services {
	@Autowired
	private repo r;
	@Autowired
	Faker f;
	
	@Override
	public List<Student_Dto> getallstudent() {

		List<Student_Entity> e=r.getallstudent();
		List<Student_Dto> dto=new ArrayList<>();
		
		for (Student_Entity se : e) {
			Student_Dto dto1=(Student_Dto) Helper.entitytodto(se);
			dto.add(dto1);
		}
	return dto;	
		
	}
	
	public String SaveData() {
		for(int i=1;i<=1000;i++) {
			Student_Entity se=new Student_Entity();
			se.setRollno(f.number().numberBetween(1, 1001));
			se.setFname(f.name().firstName());
			se.setLname(f.name().lastName());
			se.setCity(f.address().city());
			
			r.save(se);
		}
		return "Data has been Saved";
	}
	
	@Override
	public List<Student_Dto> getstudentbyrollno(Integer rollno) {
		
		List<Student_Entity> e=r.getstudentbyrollno(rollno);
		List<Student_Dto> dto2=new ArrayList<>();
		
		for (Student_Entity se : e) {
			Student_Dto dto1=(Student_Dto) Helper.entitytodto(se);
			dto2.add(dto1);
		}
	return dto2;	
	}

	@Override
	public List<Student_Dto> getstudentbylname(String lname) {
		

		List<Student_Entity> e=r.getstudentbylname(lname);
		List<Student_Dto> dto2=new ArrayList<>();
		
		for (Student_Entity se : e) {
			Student_Dto dto_city=(Student_Dto) Helper.entitytodto(se);
			dto2.add(dto_city);
		}
	return dto2;
	}

	@Override
	public List<Student_Dto> findUsersWithPartOfName(String fname) {

		List<Student_Entity> e=r.findUsersWithPartOfName(fname);
	
		List<Student_Dto> dto2=new ArrayList<>();
		
		for (Student_Entity se : e) {
			Student_Dto dto_city=(Student_Dto) Helper.entitytodto(se);
			dto2.add(dto_city);
		}
	return dto2;
		
	}

	@Override
	public List<Student_Dto> updateuser(String fname, String lname, Integer rollno) {
		List<Student_Entity> se=r.updateuser(fname, lname, rollno);
		
		
		List<Student_Dto> dtos=new ArrayList<>();
		
		for (Student_Entity student : se) {
			Student_Dto dto=Helper.entitytodto(student);
			dtos.add(dto);
		}
		return dtos;
	}
	
}
