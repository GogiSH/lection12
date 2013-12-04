package com.tsystems.orm.dal.impl;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tsystems.lection12.dao.TeacherSavchenkoDao;
import com.tsystems.lection12.entities.Teacher;
import com.tsystems.lection12.entities.TeacherReview;
import com.tsystems.lection12.entities.User;
import com.tsystems.lection12.entities.TeacherCourse;

@Stateless
public class TeacherSavchenkoDaoImpl extends GenericDaoImpl<Teacher, Integer> implements TeacherSavchenkoDao {
	
	@PersistenceContext(unitName="lection12")
	private EntityManager entityManager;
	
	@PostConstruct
	public void initialize(){
		System.out.println("===================================");
		System.out.println("TeacherSavchenkoDaoImpl initialized.");
		System.out.println("===================================");
	}
	
	@PreDestroy
	public void destroyBean(){
		System.out.println("===================================");		
		System.out.println("TeacherSavchenkoDaoImpl destroy.");
		System.out.println("===================================");
	}
	
	@Override
	public void createTeacher(Teacher teacher) {
		save(teacher);
	}
	
	@Override
	public void deleteTeacherById(Integer id) {
		Teacher teacher = findTeacherById(id);
		delete(teacher);
	}
	
	@Override
	public Teacher findTeacherById(Integer id) {
		return (Teacher) findById(Teacher.class, id);
	}

	@Override
	public List<Teacher> findAllTeachers() {
		return findAll(Teacher.class);
	}
	
	
	@Override
	public List<Teacher> getMoreExperienceTeachers(){
		Query query = entityManager.createQuery("from TEACHER t where t.experience = (select MAX(experience) from TEACHER)");
		return query.getResultList();
	}
	
	@Override
	public List<Teacher> getNotMoreExperienceTeachers(){
		Query query = entityManager.createQuery("from TEACHER t where t.experience = (select MIN(experience) from TEACHER)");
		return query.getResultList();
	}
	
	@Override
	public List<TeacherCourse> findTeacherCourses(Teacher teacher){
		Query query = entityManager.createQuery("from TEACHER_COURSE where teacher_id = :teacher_Id");
		query.setParameter("teacher_Id", teacher.getId());
		return query.getResultList();
	}
	
	@Override
	public List<TeacherReview> findTeacherReviews(Teacher teacher){
		Query query = entityManager.createQuery("from TEACHER_REVIEW where teacher_id = :teacher_Id");
		query.setParameter("teacher_Id", teacher.getId());
		return query.getResultList();
	}	

}