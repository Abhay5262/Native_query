package com.Student_nativeQuery.utils;

import com.Student_nativeQuery.Entity.Student_Entity;
import com.Student_nativeQuery.dto.Student_Dto;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Helper {
	public static Student_Dto entitytodto(Student_Entity e) {
		ObjectMapper mapper= new ObjectMapper();
		return mapper.convertValue(e, Student_Dto.class);
	}
	
	public static Student_Entity dtotoentity(Student_Dto d) {
		ObjectMapper mapper= new ObjectMapper();
		return mapper.convertValue(d, Student_Entity.class);
	}
}
