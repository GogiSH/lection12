package com.tsystems.orm.dal;

import java.util.List;

import com.tsystems.orm.entities.Subject;

public interface SubjectDao extends GenericDao<Subject,Integer>{

	public List<Subject> getAllSubjects();
	public Subject getMostPopularSubject();
	public Subject getSubjectByID(int id);
	public void createSubject(Subject subject);
	public void changeSubjectName(Subject subject, String name);
	
}
