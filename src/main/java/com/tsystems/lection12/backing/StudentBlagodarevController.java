package com.tsystems.lection12.backing;

import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.HibernateException;

import com.tsystems.lection12.entities.Student;
import com.tsystems.lection12.entities.User;
import com.tsystems.lection12.service.StudentBlagodarevService;
import com.tsystems.lection12.service.UserService;

@Named
@RequestScoped
public class StudentBlagodarevController {
	
	@Inject
	private UserService userService;
	
	@Inject
	private StudentBlagodarevService studentService;
	
	public String testCreateStudent(){
		try {
		User userFromDb = (User) userService.findUserByEmail("L12UserBlagodarev@gmail.com");
		if (userFromDb == null){
			User user = generateUser();
			userService.createUser(user);
			userFromDb = (User) userService.findUserByEmail("L12UserBlagodarev@gmail.com");
		}		
		studentService.createStudent(genenerateStudent(userFromDb));
		System.out.println("----------------------------------------------------------");
		System.out.println("Create new Student item");
		System.out.println("----------------------------------------------------------");
		} catch (HibernateException ex) {
			System.out.println(ex.getMessage());			
		}
		return "";
	}
	
	public String testDeleteStudent(){
		
		try {

			User user = generateUser();
			studentService.deleteStudentByStudentNo(genenerateStudent(user)
					.getStudentNo());
			userService.deleteUserByEmail(user.getEmail());
			System.out
					.println("----------------------------------------------------------");
			System.out.println("Delete Student item");
			System.out
					.println("----------------------------------------------------------");
		} catch (javax.ejb.EJBTransactionRolledbackException ex) {
			System.out.println(ex.getMessage());
		}
		return "";		
	}
	
	public String testFindAllStudents(){
		System.out.println("----------------------------------------------------------");
		List<Student> students = studentService.findAllStudents();
		System.out.println("Find All Student item");
		for (int i = 0; i < students.size(); ++i) {
			Student student = students.get(i);
			System.out.println(student.getId() + " " + student.getUser().getId() + " " + student.getStudentNo() );
		}
		System.out.println("----------------------------------------------------------");	
		return "";
	}
	
	public String testFindStudentByStudentNo(){
		try
		{
		
		Student student = studentService.findStudentByStudentNo("N238422");
		System.out.println("----------------------------------------------------------");
		System.out.println("Find By StudentNo Student item");
		System.out.println(student.getId() + " " + student.getUser().getId() + " " + student.getStudentNo());
		System.out.println("----------------------------------------------------------");	
		} catch (javax.ejb.EJBTransactionRolledbackException ex) {
			System.out.println(ex.getMessage());
		}
		
		return "";
	}
	
	private User generateUser(){
		User user = new User();
		user.setFirstName("L12UserSergey");
		user.setLastName("L12UserBlagodarev");
		user.setEmail("L12UserBlagodarev@gmail.com");
		user.setPassword("12345");
		user.setBirthday(new Date());
		return user;
	}
	
	private Student genenerateStudent(User user)	{
		Student student = new Student();
		student.setStudentNo("N238422");
		student.setUser(user);
		return student;
	}
	

}
