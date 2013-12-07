package com.tsystems.lection12.backing;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.tsystems.lection12.dao.CourseZyazinaDao;
import com.tsystems.lection12.entities.Course;

@Named
@RequestScoped

public class CourseZyazinaController {
	
	@Inject
	private CourseZyazinaService courseService;
	
	private Course generateCourse(){
		Course course = new Course();
		course.setName("New name");
		course.setDescription("New description");
		return course;
	}
	
	
	public String testCreateCourse(){
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Create new Course item");
		courseService.createCourse(generateCourse());
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		return "";	
	}
	
	public String testDeleteCourse(){
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Delete Course item");
		courseService.deleteCourseById(generateCourse().getId());
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		return "";
	}
	
	public String testDeleteCourseByName(){
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Delete Course item");
		courseService.deleteCourseByName(generateCourse().getName());
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		return "";
	}
	
	public String testGetAllCourses() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Start Finding courses");
		List<Course> courses = (ArrayList<Course>) courseService.getAllCourses();
		for (Courses course : courses) {
			System.out.println(course.getName());
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		return "";
	}
	
	public String testGetCourseByName() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Start Finding course");
		Course course = courseService.getCourseByName(generateCourse().getName());
		System.out.println(course.getName());
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		return "";
	}
	
	public String testGetCourseById() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Start Finding course");
		Course course = courseService.findCourseById(generateCourse().getId());
		System.out.println(course.getName());
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		return "";
	}
}