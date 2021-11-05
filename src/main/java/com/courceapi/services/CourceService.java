package com.courceapi.services;

import java.util.List;

import com.courceapi.entities.Course;

public interface CourceService {

	public List<Course> getCourses();

	public Course getCourse(Long id);

	public Course addCource(Course course);

	public Course updateCourse(Course course);

	public void deleteCourse(long id);
}
