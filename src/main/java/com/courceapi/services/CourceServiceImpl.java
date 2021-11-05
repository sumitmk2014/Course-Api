package com.courceapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courceapi.dao.Coursedao;
import com.courceapi.entities.Course;

@Service
public class CourceServiceImpl implements CourceService {
	
	
//	List<Course> list;
	@Autowired
	private Coursedao coursedao;

	public CourceServiceImpl() {
//		list=new ArrayList<>();
//		list.add(new Course(12,"java","basics of java"));
//		list.add(new Course(13,"python","basics of python"));
//		
	}

	@Override
	public List<Course> getCourses() {		
		return coursedao.findAll();
	}

		@Override
		public Course getCourse(Long id) {
//			Course course=null;
//			for(Course c:list) {
//				if(c.getId()==id) {
//					course=c;
//					break;
//				}
//		}
		return coursedao.getOne(id);
	     }

		@Override
		public Course addCource(Course course) {
//			list.add(course);	
			coursedao.save(course);
			return course;
		}

		@Override
		public Course updateCourse(Course course) {
//			Course newcourse=null;
//			for(Course c:list) {
//				if(c.getId()==course.getId()) {
//					c.setTitle(course.getTitle());
//					c.setDescription(course.getDescription());
//					break;
//				}}
//			return newcourse;   or  =>
//			list.forEach(c ->{if(c.getId()==course.getId()) {
//				c.setTitle(course.getTitle());
//				c.setDescription(course.getDescription());
//			}
//			});
			coursedao.save(course);
			
			return course;
		}

		@Override
		public void deleteCourse(long id) {
			
//			for(Course c:list) {
//				if(c.getId()==id) {
//					list.remove(c);
//					break;
//				}
//		}
//			list=this.list.stream().filter(c->c.getId()!=id).collect(Collectors.toList()); 
			Course entity = coursedao.getOne(id);
			coursedao.delete(entity);
		}
	
	

}
