package com.courceapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.courceapi.entities.Course;

public interface Coursedao extends JpaRepository<Course,Long> {
	

	
}
