package com.courceapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.courceapi.entities.Course;
import com.courceapi.services.CourceService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class Mycontroller {
	
	@Autowired
	private CourceService courceservice;
	
	@GetMapping("/home")
	public String home() {
		return "this is home";
	}
   
	@GetMapping("/cources")
	public List<Course> getCourses(){
		
	return  this.courceservice.getCourses();
	}
	@GetMapping("/cource/{id}")
	public Course getCourse(@PathVariable String id ){
		
	return  this.courceservice.getCourse(Long.parseLong(id));
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/cources")
	public Course addCourse(@RequestBody Course course) {
		return this.courceservice.addCource(course);
		
	}
	@PutMapping("/cources")
	public Course updateCourse(@RequestBody Course course) {
		
		return this.courceservice.updateCourse(course);
	}
	@DeleteMapping("/cource/{id}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String id){
		try {
	 this.courceservice.deleteCourse(Long.parseLong(id));
	 return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception e) {
			 return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}
	}

	
	
	
	
	
	

