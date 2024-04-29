package com.Student_nativeQuery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Student_nativeQuery.Services.Services;
import com.Student_nativeQuery.dto.Student_Dto;



@RestController
public class Student_controller {
	@Autowired
	private Services services;
	
	@GetMapping("/getallStudent")
	public ResponseEntity<List<Student_Dto>> getallstudent() {
		return new ResponseEntity<List<Student_Dto>>(services.getallstudent(), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/save_data")
	public ResponseEntity<String> SaveData() {
		return new ResponseEntity<String>(services.SaveData(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getstudentbyrollno/{rollno}")
	public ResponseEntity<List<Student_Dto>> getstudentbyrollno(@PathVariable Integer rollno){
		return new ResponseEntity<List<Student_Dto>>(services.getstudentbyrollno(rollno), HttpStatus.ACCEPTED);
		}
	@GetMapping("/getstudentbylname/{lname}")
	public ResponseEntity<List<Student_Dto>> getstudentbylname(@PathVariable String lname){
		return new ResponseEntity<List<Student_Dto>>(services.getstudentbylname(lname), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/findUsersWithPartOfName/{fname}")
	public ResponseEntity<List<Student_Dto>> findUsersWithPartOfName(@PathVariable String fname) {
		return new ResponseEntity<List<Student_Dto>>(services.findUsersWithPartOfName(fname), HttpStatus.ACCEPTED);
	}
	
}
