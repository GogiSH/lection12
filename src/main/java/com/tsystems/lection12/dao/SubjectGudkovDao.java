package com.tsystems.lection12.dao;

import java.util.List;

import com.tsystems.lection12.entities.Subject;

public interface SubjectGudkovDao extends GenericDao<Subject, Integer> {

	public List<Subject> getAllSubjects();
	public void deleteSubjectById(Integer id);
	public Subject getMostPopularSubject();

	public Subject getSubjectByID(int id);

	public void createSubject(Subject subject);

	public void changeSubjectName(Subject subject, String name);

}
