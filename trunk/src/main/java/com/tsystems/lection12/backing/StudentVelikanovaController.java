package com.tsystems.lection12.backing;

import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.tsystems.lection12.entities.Student;
import com.tsystems.lection12.entities.TeacherReview;
import com.tsystems.lection12.entities.User;
import com.tsystems.lection12.service.StudentVelikanovaService;
import com.tsystems.lection12.service.UserService;

@Named
@RequestScoped
public class StudentVelikanovaController {
	
	@Inject
	private UserService userService;
	
	@Inject
	private StudentVelikanovaService studentService;
	
	private int student_id;
	
	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public void testCreateStudent(){
		User user = generateUser();
		userService.createUser(user);
		studentService.createStudent(generateStudent(user));
		System.out.println("Test1, Student was created");
	}
	
	public void testFindAllStudents(){
		System.out.println("Test2, Find all students");
		List<Student> students = studentService.findAllStudents();
		for (Student st: students) {
			System.out.println(st.getId() + " " + st.getUser().getLastName() + " " + st.getStudentNo() );
		}
	}
	public void testGetAverageRating()
	{
		System.out.println("Test3, Find average rating");
		studentService.getAverageRating(student_id);
	}
	
	public void testGetGoodReviews(){
		System.out.println("Test4, Find good reviews");
		List<TeacherReview> trs = studentService.getGoodTeacherReviews(student_id);
		for (TeacherReview t:trs) {
			System.out.println(t.getId() + " " + t.getRating() + " " +t.getReviewText() );
		}
	}
	
	private User generateUser(){
		User user = new User();
		user.setFirstName("Student");
		user.setLastName("Student");
		user.setEmail("student@gmail.com");
		user.setPassword("password");
		user.setBirthday(new Date());
		return user;
	}
	
	private Student generateStudent(User user)	{
		Student student = new Student();
		student.setStudentNo("4324324");
		student.setUser(user);
		return student;
	}
}
