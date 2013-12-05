package com.tsystems.lection12.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Remove;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import javax.persistence.Query;

import com.tsystems.lection12.dao.SubjectGudkovDao;
import com.tsystems.lection12.entities.Subject;


@Stateless
public class SubjectGudkovDaoImpl extends GenericDaoImpl<Subject, Integer> implements
		SubjectGudkovDao {

	@PersistenceContext(unitName="lection12")
	EntityManager entityManager;
	
	@PostConstruct
    public void initialize () {
        // Initialize here objects which will be used
        // by the session bean
    	System.out.println("----------------------------------------------------------");
        System.out.println("SubjectDaoImpl initialized.");
    } 

    @PreDestroy
    public void destroyBean() {
        // Free here resources acquired by the session bean
        System.out.println("SubjectDaoImpl destroy.");
    	System.out.println("----------------------------------------------------------");
    }

	public List<Subject> getAllSubjects() {
		return findAll(Subject.class);
	}

	public Subject getMostPopularSubject() {
		String select = "Select sub from Subject as sub , TeacherCourse as tc where sub.id = tc.subject.id and tc.course.id =(Select tc.course.id from TeacherCourse tc where tc.hours=(Select max(tc.hours) from TeacherCourse tc) )";
		Query query= entityManager.createQuery(select);
		
		return (Subject)query.getSingleResult();
	}

	public Subject getSubjectByID(int id) {
		return findById(Subject.class, id);
	}

	public void createSubject(Subject subject) {
		save(subject);
		
	}

	public void changeSubjectName(Subject subject, String name) {
		subject.setName(name);
		merge(subject);
		
	}

	public void deleteSubjectById(Integer id) {
		Subject subject = findById(Subject.class, id);
		super.delete(subject);
		
	}

	public void deleteSubjectByDesc(String desc) {
		Query query =  entityManager.createQuery("from Subject sub where description=:desc");
		query.setParameter("desc", desc);
		List<Subject> list= query.getResultList();
		for (Subject sb: list){
			super.delete(sb);
		}
	
		
		
	}

	public List<Subject> getSubjectByDesc(String desc) {
		Query query =  entityManager.createQuery("from Subject sub where description=:desc");
		query.setParameter("desc", desc);
		return  query.getResultList();
	}


}
