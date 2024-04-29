package com.Student_nativeQuery.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student_Entity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sr_no;
	private Integer rollno;
	private String fname;
	private String lname;
	private String city;
}
