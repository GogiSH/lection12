	package com.tsystems.lection12.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.tsystems.lection12.dao.CourseZyazinaDao;
import com.tsystems.lection12.entities.Course;

@Stateless
public class CourseZyazinaService {
	
}
	@Inject
	private CourseZyazinaDao courseDao;
	
	@PostConstruct
    public void initialize () {        
    	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("CourseService Session Bean initialized.");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    } 

    @PreDestroy
    public void destroyBean() {
    	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("CourseService Session Bean destroy.");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");    
    } 
    
    public List<Course> getAllCourses(){
    	courseDao.getAllCourses();
    }
    
	public void deleteCourseById(Integer id){
		courseDao.deleteCourseById(id);
	}
	
	public Course getCourseByID(int id){
		return courseDao.getCourseByID(id)
	}
	
	public void deleteCourseByName(String name){
		courseDao.deleteCourseByName(name);
	}
	
	public Course getCourseByName(String name){
		return courseDao.getCourseByName(name)
	}
	
	public void createCourse(Course course){
		courseDao.createCourse(course);
	}

	public void changeCourseName(Course course, String name){
		courseDao.changeCourseName(course,name);
	}
	
	public void changeCourseDescription(Course course, String description){
		courseDao.changeCourseDescription(course,description);
	}
	