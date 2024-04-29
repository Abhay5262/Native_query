package com.Student_jpql.utils;

import org.springframework.stereotype.Component;

import com.Student_jpql.Dto.Student_dto;
import com.Student_jpql.Entity.Student_Entity;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Helper {
	

	
	public static Student_dto entitytodto(Student_Entity e) {
		ObjectMapper mapper= new ObjectMapper();
		return mapper.convertValue(e, Student_dto.class);
	}
	
	public static Student_Entity dtotoentity(Student_dto d) {
		ObjectMapper mapper= new ObjectMapper();
		return mapper.convertValue(d, Student_Entity.class);
	}
}
