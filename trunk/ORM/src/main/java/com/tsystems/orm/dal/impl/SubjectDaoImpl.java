package com.tsystems.orm.dal.impl;

import java.util.List;

import org.hibernate.Query;

import com.tsystems.orm.dal.SubjectDao;
import com.tsystems.orm.entities.Subject;
import com.tsystems.orm.util.HibernateUtils;

public class SubjectDaoImpl extends GenericDaoImpl<Subject, Integer> implements
		SubjectDao {

	@Override
	public List<Subject> getAllSubjects() {
		return findAll(Subject.class);
	}

	@Override
	public Subject getMostPopularSubject() {
		Query query = HibernateUtils
				.getSession()
				.createQuery(
						"Select Distinct Subject.name,Subject.description "
						+ "from Subject join Teacher_Course where subject.id = Teacher_Course.subject_id and"
						+ " Teacher_Course.course_id =(Select course_id from Teacher_Course group by course_id "
						+ "having count(Teacher_Course.course_id) = "
						+ "(Select max(temp.num) num  from "
						+ "(Select count(course_id) num from Teacher_Course group by course_id) temp))");
		return (Subject) query.uniqueResult();
	}

}
