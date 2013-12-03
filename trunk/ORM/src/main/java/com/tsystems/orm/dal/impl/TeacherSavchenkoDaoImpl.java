package com.tsystems.orm.dal.impl;


import java.util.List;

import org.hibernate.Query;

import com.tsystems.orm.dal.TeacherDao;
import com.tsystems.orm.entities.Teacher;
import com.tsystems.orm.util.HibernateUtils;


public class TeacherSavchenkoDaoImpl extends GenericDaoImpl<Teacher, Integer> implements TeacherDao {
	
	@Override
	public Teacher findTeacherById(Integer id) {
		return (Teacher) findById(Teacher.class, id);
	}

	@Override
	public void createStudent(Teacher student) {
		save(student);
	}

	@Override
	public List<Teacher> getAllTeacher() {
		return findAll(Student.class);
	}

}