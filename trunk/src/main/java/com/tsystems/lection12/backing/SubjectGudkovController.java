package com.tsystems.lection12.backing;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.tsystems.lection12.entities.Subject;
import com.tsystems.lection12.entities.User;
import com.tsystems.lection12.service.SubjectGudkovService;


@Named
@RequestScoped
public class SubjectGudkovController {
	
	@Inject
	private SubjectGudkovService subjectService;
	
	public String testCreateUser(){
		System.out.println("----------------------------------------------------------");
		System.out.println("Create new Subject item");
		subjectService.createSubject(generateSubject());
		System.out.println("----------------------------------------------------------");
		return "";
	}
	
	public String testDeleteSubject(){
		System.out.println("----------------------------------------------------------");
		System.out.println("Delete Subject item");
		subjectService.deleteSubjectbyId(generateSubject().getId());
		System.out.println("----------------------------------------------------------");
		return "";
	}
	
	public String testDeleteSubjectByDesc(){
		System.out.println("----------------------------------------------------------");
		System.out.println("Delete Subject item");
		subjectService.deleteSubjectbyDesc(generateSubject().getDescription());
		System.out.println("----------------------------------------------------------");
		return "";
	}
	
	public String testFindAllSubjects() {
		System.out.println("----------------------------------------------------------");
		System.out.println("Start Finding subjects");
		List<Subject> subjects = (ArrayList<Subject>) subjectService.findAllSubjects();
		for (Subject subject : subjects) {
			System.out.println(subject.getName());
		}
		System.out.println("----------------------------------------------------------");
		return "";
	}
	
	public String testSubjectByDesc() {
		System.out.println("----------------------------------------------------------");
		System.out.println("Start Finding subjects");
		List<Subject> subjects = (ArrayList<Subject>) subjectService.getSubjectByDesc(generateSubject().getDescription());
		for (Subject subject : subjects) {
			System.out.println(subject.getName());
		}
		System.out.println("----------------------------------------------------------");
		return "";
	}
	public String testFindSubjectById() {
		System.out.println("----------------------------------------------------------");
		System.out.println("Start Finding subject by ID");
		Subject subject = subjectService.findSubjectById(generateSubject().getId());
		System.out.println(subject.getName());
		System.out.println("----------------------------------------------------------");
		return "";
	}
	
	private Subject generateSubject(){
		Subject subject = new Subject();
		subject.setName("Some name");
		subject.setDescription("Some desc");
		return subject;
	}
	
	

}
