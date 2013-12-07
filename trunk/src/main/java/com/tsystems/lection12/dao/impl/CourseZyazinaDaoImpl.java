package com.tsystems.lection12.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tsystems.lection12.dao.CourseZyazinaDao;
import com.tsystems.lection12.entities.Course;

@Stateless
public class CourseZyazinaDaoImpl extends GenericDaoImpl<Course, Integer> implements CourseZyazinaDao{
	
	@PersistenceContext(unitName="lection12")
	private EntityManager entityManager;
	
	@PostConstruct
    public void initialize () {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("CourseDaoImpl initialized.");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    } 
	
	@PreDestroy
    public void destroyBean() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("CourseDaoImpl destroy.");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
	
	@Override
	public List<Course> getAllCourses(){
		return findAll(Course.class);
	}
	
	@Override
	public void deleteCourseById(Integer id){
		Course course = findById(Course.class, id);
		super.delete(course);
	}
	
	@Override
	public Course getCourseByID(int id){
		return findById(Course.class, id);
	}
	
	@Override
	public void deleteCourseByName(String name){
		Query query =  entityManager.createQuery("from COURSE where NAME = :name");
		query.setParameter("name", desc);
		Course course = query.getResultList();
		super.delete(course);
	}
	
	@Override
	public Course getCourseByName(String name){
		Query query =  entityManager.createQuery("from COURSE where NAME=:name");
		query.setParameter("name", name);
		return  query.getResultList();
	}
	
	@Override
	public void createCourse(Course course){
		save(course);
	}

	@Override
	public void changeCourseName(Course course, String name){
		course.setName(name);
		merge(course);
	}
	
	@Override
	public void changeCourseDescription(Course course, String description){
		course.setDescription(description);
		merge(course);
	}
}