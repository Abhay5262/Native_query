package com.Student_nativeQuery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student_Dto {
	private Long sr_no;
	private String rollno;
	private String fname;
	private String lname;
	private String city;
}
