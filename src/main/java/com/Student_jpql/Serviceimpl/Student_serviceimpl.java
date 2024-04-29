package com.Student_jpql.Serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Student_jpql.Dto.Student_dto;
import com.Student_jpql.Entity.Student_Entity;
import com.Student_jpql.repository.Student_repo;
import com.Student_jpql.services.Service;
import com.Student_jpql.utils.Helper;

@Component
public class Student_serviceimpl implements Service {
	@Autowired
	private Student_repo r;
	public List<Student_dto> getallstudent() {
//		List<StudentEntity> se= (List<StudentEntity>) r.findAll();
//		
//		List<Student_Dto> dtos=new ArrayList<>();
// 	
//for (StudentEntity se1 : se) {
//		Student_Dto sd=new Student_Dto();
//		sd.setName(se1.getName());
//		sd.setCity(se1.getCity());
//		sd.setRollno(se1.getRollno());
//		
//		dtos.add(sd);
//	}
		/*Using jpql */
		
		List<Student_Entity> e=r.getallstudent();
		List<Student_dto> dto=new ArrayList<>();
		
		for (Student_Entity se : e) {
			Student_dto dto1=(Student_dto) Helper.entitytodto(se);
			dto.add(dto1);
		}
	return dto;	
	}
	

	public String savestudent(Student_dto student1) {
		Student_Entity SE=new Student_Entity();
		SE.setName(student1.getName());
		SE.setAddres(student1.getAddres());
		SE.setRollno(student1.getRollno());
		r.save(SE);
		return "Data has been Saved";
	}

	

	public String deletebyid(String rollno) {
		r.deletebyid(rollno);
		return "Data deleted";
	}

	public String deleteall() {
		r.deleteAll();
		return "All Data has been deleted";
	}


	@Override
	public Optional<Student_dto> getstudentbyid(String rollno) {
		
		Student_Entity databyid=r.getstudentbyid(rollno);
		
		Student_dto conertentitytoDto = Helper.entitytodto(databyid);
		
		return Optional.of(conertentitytoDto);
	}


	@Override
	public List<Student_dto> findUsersWithAddress() {
		List<Student_Entity> entity=(List<Student_Entity>) r.findUsersWithAddress();
		List<Student_dto> sDtos=new ArrayList<>();
		for (Student_Entity student_Entity : entity) {
			Student_dto entitytodto = Helper.entitytodto(student_Entity);
			sDtos.add(entitytodto);
		}
		
		return sDtos;
	}



}
