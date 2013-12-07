package com.tsystems.lection12.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.tsystems.lection12.dao.StudentKobylkinDao;
import com.tsystems.lection12.entities.Student;
import com.tsystems.lection12.entities.TeacherReview;
import com.tsystems.lection12.entities.User;

@Stateless
public class StudentKobylkinService {
	
	@Inject
	private StudentKobylkinDao studentDao;
	
    @PostConstruct
    public void initialize () {
        System.out.println("StudentService Session Bean has been initialized.");
    } 

    @PreDestroy
    public void destroyBean() {
        System.out.println("StudentService Session Bean has been destroyed.");      
    } 
    
	public void createStudent(Student student){
		studentDao.createStudent(student);
	}
	
	public void deleteStudent(Student student){
		studentDao.delete(student);		
	}
		
	public void setStudentNo(Student student, String studentNo){
		studentDao.setStudentNo(student, studentNo);
	}
	
	public Student findStudentById(Integer id){
		return studentDao.findStudentById(id);		
	}
	
	public Student findStudentByStudentNo(String studentNo){
		return studentDao.findStudentByStudentNo(studentNo);		
	}
	
	public List<Student> findStudentsByUser(User user){
		return studentDao.findStudentsByUser(user);		
	}
	
	public List<TeacherReview> findTeachersReview(Student student){
		return studentDao.findTeachersReview(student);
	}
	
	public List<Student> findAllStudents(){
		return studentDao.findAllStudents();	
	}
	
	public List<Integer> findGoodStudents(){
		return studentDao.findGoodStudents();
	}

}
