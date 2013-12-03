package com.tsystems.orm.dal.impl;

import java.util.List;

import org.hibernate.Query;

import com.tsystems.orm.dal.SubjectGudkovDao;
import com.tsystems.orm.entities.Subject;
import com.tsystems.orm.util.HibernateUtils;

public class SubjectGudkovDaoImpl extends GenericDaoImpl<Subject, Integer> implements
		SubjectGudkovDao {

	@Override
	public List<Subject> getAllSubjects() {
		return findAll(Subject.class);
	}

	@Override
	public Subject getMostPopularSubject() {
		String select = "Select sub from Subject as sub , TeacherCourse as tc where sub.id = tc.subject.id and tc.course.id =(Select tc.course.id from TeacherCourse tc where tc.hours=(Select max(tc.hours) from TeacherCourse tc) )";
		Query query = HibernateUtils
				.getSession()
				.createQuery(select);
		return (Subject) query.uniqueResult();
	}

	@Override
	public Subject getSubjectByID(int id) {
		return findById(Subject.class, id);
	}

	public void createSubject(Subject subject) {
		save(subject);
	}

	@Override
	public void changeSubjectName(Subject subject, String name) {
		subject.setName(name);
		merge(subject);
	}

}
