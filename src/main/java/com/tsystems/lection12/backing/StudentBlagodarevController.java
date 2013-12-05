package com.tsystems.lection12.backing;

import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

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
		System.out.println("----------------------------------------------------------");
		User user = generateUser();
		userService.createUser(user);
		studentService.createStudent(genenerateStudent(user));
		System.out.println("Create new Student item");
		System.out.println("----------------------------------------------------------");
		return "";
	}
	
	public String testDeleteStudent(){
		System.out.println("----------------------------------------------------------");
		User user = generateUser();
		studentService.deleteStudentByStudentNo(genenerateStudent(user).getStudentNo());
		userService.deleteUserByEmail(user.getEmail());
		System.out.println("Delete Student item");
		System.out.println("----------------------------------------------------------");
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
		System.out.println("----------------------------------------------------------");
		Student student = studentService.findStudentByStudentNo("N238422");
		System.out.println("Find By StudentNo Student item");
		System.out.println(student.getId() + " " + student.getUser().getId() + " " + student.getStudentNo());
		System.out.println("----------------------------------------------------------");	
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
