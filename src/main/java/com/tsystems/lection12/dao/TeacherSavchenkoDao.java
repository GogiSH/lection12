package com.tsystems.lection12.dao;

import java.util.List;

import com.tsystems.lection12.entities.Teacher;
import com.tsystems.lection12.entities.TeacherReview;
import com.tsystems.lection12.entities.TeacherCourse;

public interface TeacherSavchenkoDao extends GenericDao<Teacher, Integer>{	
	public void createTeacher(Teacher teacher);
	public void deleteTeacherById(Integer id);
	public Teacher findTeacherById(Integer id);
	public List<Teacher> findAllTeachers();
	public List<Teacher> getMoreExperienceTeachers();	
	public List<Teacher> getNotMoreExperienceTeachers();
	public List<TeacherCourse> findTeacherCourses(Teacher teacher);
	public List<TeacherReview> findTeacherReviews(Teacher teacher);
}