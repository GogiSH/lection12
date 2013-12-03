package com.tsystems.orm.dal.impl;


import java.util.List;

import org.hibernate.Query;

import com.tsystems.orm.dal.impl.TeacherSavchenkoDao;
import com.tsystems.orm.entities.Teacher;
import com.tsystems.orm.util.HibernateUtils;


public class TeacherSavchenkoDaoImpl extends GenericDaoImpl<Teacher, Integer> implements TeacherSavchenkoDao {
	
	@Override
	public Teacher findTeacherById(Integer id) {
		return (Teacher) findById(Teacher.class, id);
	}

	@Override
	public void createStudent(Teacher teacher) {
		save(teacher);
	}

	@Override
	public List<Teacher> findAllTeacher() {
		return findAll(Student.class);
	}
	
	@Override
	public double getAverageExperience(int teacher_id)
	{
		Query query = HibernateUtils.getSession().createQuery("select avg(experience) from Teacher where id_ = :teacher_id");
		query.setInteger("teacher_id", teacher_id);
		return (double) query.uniqueResult();
	}
	
	@Override
	public int getMoreExperienceTeacherID(){
		Query query = HibernateUtils.getSession().createQuery("select t.id_ from teacher t where t.experience = (select MAX(experience) from teacher)");
		return (double) query.uniqueResult();
	}
	
	

}