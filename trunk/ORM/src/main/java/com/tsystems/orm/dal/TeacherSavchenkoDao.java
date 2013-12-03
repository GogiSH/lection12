package com.tsystems.orm.dal;

import java.util.List;

import com.tsystems.orm.dal.GenericDao;
import com.tsystems.orm.entities.Teacher;

public class TeacherSavchenkoDao extends GenericDao<Teacher, Integer>{
	public Teacher findTeacherById(Integer id);
	public void createTeacher(Teacher teacher);
	public List<Teacher> findAllTeachers();
	public double getAverageExperience(int teacher_id); 
	public int getMoreExperienceTeacherID();
}