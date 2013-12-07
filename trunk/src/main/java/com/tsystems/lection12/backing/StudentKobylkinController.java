package com.tsystems.lection12.backing;

import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.tsystems.lection12.entities.Student;
import com.tsystems.lection12.entities.User;
import com.tsystems.lection12.service.StudentKobylkinService;
import com.tsystems.lection12.service.UserService;

@Named
@RequestScoped
public class StudentKobylkinController {
	
	@Inject
	private UserService userService;
	
	@Inject
	private StudentKobylkinService studentService;
	
	public void testCreateStudent(){
		User user = generateUser();
		userService.createUser(user);
		studentService.createStudent(genenerateStudent(user));
		System.out.println("Create new Student item");
	}
	
	public void testDeleteStudent(){
		
		try {

			User user = generateUser();
			studentService.deleteStudent(genenerateStudent(user));
			userService.deleteUserByEmail(user.getEmail());
			System.out.println("Delete Student item");
		} catch (javax.ejb.EJBTransactionRolledbackException ex) {
			System.out.println(ex.getMessage());
		}	
	}
	
	public void testFindAllStudents(){
		List<Student> students = studentService.findAllStudents();
		System.out.println("Find All Student item");
		for (int i = 0; i < students.size(); ++i) {
			Student student = students.get(i);
			System.out.println(student.getId() + " " + student.getUser().getId() + " " + student.getStudentNo() );
		}
	}
	
	public void testFindGoodStudents(){
		List<Integer> goodStudents = studentService.findGoodStudents();
		System.out.println("Find good students");
		for (int i = 0; i < goodStudents.size(); ++i) {
			Integer id = goodStudents.get(i);
			System.out.println(id);
		}
	}
	
	private User generateUser(){
		User user = new User();
		user.setFirstName("test");
		user.setLastName("test");
		user.setEmail("test@mail.ru");
		user.setPassword("testpass");
		user.setBirthday(new Date());
		return user;
	}
	
	private Student genenerateStudent(User user)	{
		Student student = new Student();
		student.setStudentNo("123456");
		student.setUser(user);
		return student;
	}
}
