package com.Student_jpql.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Student_jpql.Dto.Student_dto;
import com.Student_jpql.services.Service;


@RestController
public class Student_controller {
	@Autowired
	private Service s;
	

	@GetMapping("/getallstudent")        	 
	public ResponseEntity<List<Student_dto>> getallstudent(){
		return new ResponseEntity<>(s.getallstudent(), HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value ="/savestudent")
	public ResponseEntity<String> savestudent( @RequestBody Student_dto st) {
		return new ResponseEntity<>(s.savestudent(st),HttpStatus.CREATED);	
	}
	@GetMapping("/getstudentbyid/{rollno}")
	public ResponseEntity<Optional<Student_dto>> getstudentbyid(@PathVariable String rollno){
		return new ResponseEntity<>(s.getstudentbyid(rollno),HttpStatus.BAD_REQUEST);
	}
	

	@DeleteMapping("/deletebyid/{rollno}")
	public String deletebyid(@PathVariable String rollno){
		return s.deletebyid(rollno);
	}
	
	@DeleteMapping("/deleteall")
	public String deleteall(){
		return s.deleteall();
	}
	
	@GetMapping("/getbycity")
	public List<Student_dto> findUsersWithAddress(){
		return s.findUsersWithAddress();
		
	}
	
}
