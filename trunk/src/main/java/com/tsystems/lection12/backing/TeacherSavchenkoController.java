package com.tsystems.lection12.backing;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.tsystems.lection12.entities.User;
import com.tsystems.lection12.entities.Teacher;
import com.tsystems.lection12.entities.TeacherCourse;
import com.tsystems.lection12.entities.TeacherReview;
import com.tsystems.lection12.service.TeacherSavchenkoService;


@Named
@RequestScoped
public class TeacherSavchenkoController {

	@Inject
	private TeacherSavchenkoService teacherService;
	
	public String testCreateTeacher(){
		System.out.println("==========================================================");
		System.out.println("Create new Teacher item");
		teacherService.createTeacher(generateTeacher());
		System.out.println("==========================================================");
		return "";
	}
	
	public String testDeleteTeacher() {
		System.out.println("==========================================================");
		System.out.println("Teacher with ID = 1024 deleted");
		teacherService.deleteTeacherById(1024);
		System.out.println("==========================================================");
		return "";
	}
	
	public String testFindAllTeachers() {
		System.out.println("==========================================================");
		System.out.println("All Teachers:");
		List<Teacher> teachers = (ArrayList<Teacher>) teacherService.findAllTeachers();
		for (Teacher teacher : teachers) {
			printTeacher(teacher);
		}
		System.out.println("==========================================================");
		return "";
	}
	
	public String testGetMoreExperienceTeachers() {
		System.out.println("==========================================================");
		System.out.println("More Experience Teachers:");
		List<Teacher> teachers = (ArrayList<Teacher>) teacherService.getMoreExperienceTeachers();
		for (Teacher teacher : teachers) {
			printTeacher(teacher);
		}
		System.out.println("==========================================================");
		return "";
	}	
	
    private void printTeacher(Teacher teacher){
    	User user = teacher.getUser();
    	System.out.println(user.getFirstName() + " | " + user.getLastName() + " | " + user.getEmail() + " | " + teacher.getExperience());
    }
	
	private User generateUser(){
		User user = new User();
		user.setId(512);
		user.setFirstName("L12User_Name");
		user.setLastName("L12User_Familiy");
		user.setEmail("L12User_Teacher@gmail.com");
		user.setPassword("password");
		user.setBirthday(new Date());
		return user;
	}
	
	private Teacher generateTeacher(){
		Teacher teacher = new Teacher(generateUser());
		teacher.setId(1024);
		teacher.setExperience(10);
		return teacher;
	}
}
