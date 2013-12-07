package com.tsystems.lection12.dao;

import java.util.List;

import com.tsystems.lection12.entities.Course;

public interface CourseZyazinaDao extends GenericDao<Course, Integer> {
	
	public List<Course> getAllCourses();
	public void deleteCourseById(Integer id);
	public Course getCourseByID(int id);
	public void deleteCourseByName(String name);
	public Course getCourseByName(String name);
	
	public void createCourse(Course course);

	public void changeCourseName(Course course, String name);
	public void changeCourseDescription(Course course, String description);
}