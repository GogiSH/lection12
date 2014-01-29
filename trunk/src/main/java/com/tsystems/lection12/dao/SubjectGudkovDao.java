package com.tsystems.lection12.dao;

import java.util.List;

import com.tsystems.lection12.entities.Subject;

public interface SubjectGudkovDao extends GenericDao<Subject, Integer> {

	public List<Subject> getAllSubjects();
	public void deleteSubjectById(Integer id);
	public Subject getMostPopularSubject();
	public List<Subject> getSubjectByDesc(String desc);
	public Subject getSubjectByID(int id);
	public void deleteSubjectByDesc(String desc);
	public void deleteSubjectByName(String name);
	public void createSubject(Subject subject);
	public void changeSubjectDesc(Subject subject, String desc);
	public void changeSubjectName(Subject subject, String name);
	public List<Subject> getSubjectByName(String name);
}
