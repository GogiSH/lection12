package com.tsystems.lection12.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.tsystems.lection12.dao.SubjectGudkovDao;
import com.tsystems.lection12.entities.Subject;

@Stateless
public class SubjectGudkovService {

	@Inject
	private SubjectGudkovDao subjectDao;

	@PostConstruct
	public void initialize() {
		// Initialize here objects which will be used
		// by the session bean
		System.out
				.println("----------------------------------------------------------");
		System.out.println("Session Bean initialized.");
	}

	@PreDestroy
	public void destroyBean() {
		// Free here resources acquired by the session bean
		System.out.println("Session Bean destroy.");
		System.out
				.println("----------------------------------------------------------");
	}

	public void createSubject(Subject subject) {
		subjectDao.createSubject(subject);
		;
	}

	public void deleteSubjectbyId(Integer id){
		subjectDao.deleteSubjectById(id);
	}
	
	public void deleteSubjectbyDesc(String desc){
		subjectDao.deleteSubjectByDesc(desc);
	}
	
	public Subject findSubjectById(Integer id) {
		return subjectDao.getSubjectByID(id);
	}
	
	public List<Subject> getSubjectByDesc(String desc) {
		return subjectDao.getSubjectByDesc(desc);
	}

	public List<Subject> findAllSubjects() {
		return subjectDao.findAll(Subject.class);
	}

	public void changeSubjectName(Subject subject, String name) {
		subjectDao.changeSubjectName(subject, name);
	}

}
