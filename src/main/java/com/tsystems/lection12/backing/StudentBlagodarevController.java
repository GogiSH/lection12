package com.tsystems.lection12.backing;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.tsystems.lection12.entities.Student;
import com.tsystems.lection12.entities.User;
import com.tsystems.lection12.service.StudentBlagodarevService;

@Named
@RequestScoped
public class StudentBlagodarevController {
	
	@Inject
	private StudentBlagodarevService studentService;
	
	public String testCreateStudent(){
		System.out.println("----------------------------------------------------------");
		studentService.createStudent(genenerateStudent());
		System.out.println("Create new Student item");
		System.out.println("----------------------------------------------------------");
		return "";
	}
	
	public String testDeleteStudent(){
		System.out.println("----------------------------------------------------------");
		studentService.deleteStudent(genenerateStudent());
		System.out.println("Delete Student item");
		System.out.println("----------------------------------------------------------");
		return "";		
	}
	
	public String testFindAllStudents(){
		System.out.println("----------------------------------------------------------");
		studentService.findAllStudents();
		System.out.println("Find All Student item");
		System.out.println("----------------------------------------------------------");	
		return "";
	}
	
	public String testFindStudentByStudentNo(){
		System.out.println("----------------------------------------------------------");
		studentService.findAllStudents();
		System.out.println("Find By StudentNo Student item");
		System.out.println("----------------------------------------------------------");	
		return "";
	}
	
	private Student genenerateStudent()	{
		Student student = new Student();
		User user = new User();
		user.setId(250);
		student.setId(200);
		student.setStudentNo("N222222");
		student.setUser(user);
		return student;
	}
	

}
