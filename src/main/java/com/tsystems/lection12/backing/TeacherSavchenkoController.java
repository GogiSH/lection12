package com.tsystems.lection12.backing;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.hibernate.HibernateException;

import com.tsystems.lection12.entities.User;
import com.tsystems.lection12.entities.Teacher;
import com.tsystems.lection12.entities.TeacherCourse;
import com.tsystems.lection12.entities.TeacherReview;
import com.tsystems.lection12.service.TeacherSavchenkoService;
import com.tsystems.lection12.service.UserService;


@Named
@RequestScoped
public class TeacherSavchenkoController {

	@Inject
	private UserService userService;
	@Inject
	private TeacherSavchenkoService teacherService;
	
	public String testCreateTeacher(){
		System.out.println("==========================================================");	
		try {			
			User userFromDB = (User) userService.findUserByEmail("L12UserSavchenko@gmail.com");
			if (userFromDB == null){
				User us = generateUser();
				userService.createUser(us);
				userFromDB = (User) userService.findUserByEmail("L12UserSavchenko@gmail.com");
			}					
			teacherService.createTeacher(generateTeacher(userFromDB));
			System.out.println("Create new Teacher");
		} catch (HibernateException ex) {
			System.out.println(ex.getMessage());			
		}
		
		System.out.println("==========================================================");
		return "";
	}
	
	public String testDeleteTeacher() {
		System.out.println("==========================================================");	
		try {
			User userFromDB = (User) userService.findUserByEmail("L12UserSavchenko@gmail.com");
			if (userFromDB == null){
				System.out.println("==========================================================");
				return "";
			}
			if ( teacherService.deleteTeacherByUserId(userFromDB.getId()) > 0 )
				System.out.println("Teacher with USER_ID = "+userFromDB.getId()+" deleted");
			else 
				System.out.println("Teacher with USER_ID = "+userFromDB.getId()+" not found);
		} catch (HibernateException ex) {
			System.out.println(ex.getMessage());			
		}
		
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
		user.setFirstName("L12User_Name");
		user.setLastName("L12User_Familiy");
		user.setEmail("L12UserSavchenko@gmail.com");
		user.setPassword("password");
		user.setBirthday(new Date());
		return user;
	}
	
	private Teacher generateTeacher(User user){
		Teacher teacher = new Teacher();
		teacher.setExperience(10);
		teacher.setUser(user);
		return teacher;
	}
}
