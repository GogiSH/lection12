package com.tsystems.lection12.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.tsystems.lection12.dao.TeacherSavchenkoDao;
import com.tsystems.lection12.entities.Teacher;
import com.tsystems.lection12.entities.TeacherCourse;
import com.tsystems.lection12.entities.TeacherReview;

@Stateless
public class TeacherSavchenkoService {
		
	@Inject
	private TeacherSavchenkoDao teacherDao;
	
    @PostConstruct
    public void initialize () {        
    	System.out.println("=========================================================");
        System.out.println("TeacherSavchenkoService Session Bean initialized.");
    } 

    @PreDestroy
    public void destroyBean() {
        System.out.println("TeacherSavchenkoService Session Bean destroy.");
        System.out.println("=========================================================");     
    } 

	
    public void createTeacher(Teacher teacher) {
    	teacherDao.createTeacher(teacher);
    }
    
    public void deleteTeacherById(Integer id) {
    	teacherDao.deleteTeacherById(id);
    }
    
	public Teacher findTeacherById(Integer id) {
    	return teacherDao.findTeacherById(id);
    }
    
	public List<Teacher> findAllTeachers(){
		return teacherDao.findAllTeachers();
	}
	
	public List<Teacher> getMoreExperienceTeachers(){
		return teacherDao.getMoreExperienceTeachers();
	}
	
	public List<Teacher> getNotMoreExperienceTeachers(){
		return teacherDao.getNotMoreExperienceTeachers();
	}
	
	public List<TeacherCourse> findTeacherCourses(Teacher teacher){
		return teacherDao.findTeacherCourses(teacher);
	}
	
	public List<TeacherReview> findTeacherReviews(Teacher teacher){
		return teacherDao.findTeacherReviews(teacher);
	}
    
	
}
