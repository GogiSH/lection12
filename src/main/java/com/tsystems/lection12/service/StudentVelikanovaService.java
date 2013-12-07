package com.tsystems.lection12.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.tsystems.lection12.dao.StudentVelikanovaDao;
import com.tsystems.lection12.entities.Student;
import com.tsystems.lection12.entities.TeacherReview;

@Stateless
public class StudentVelikanovaService {
	
	@Inject
	private StudentVelikanovaDao studentDao;
    @PostConstruct
    public void initialize () {
        // Initialize here objects which will be used
        // by the session bean
    	System.out.println("----------------------------------------------------------");
        System.out.println("StudentService Session Bean initialized.");
    } 

    @PreDestroy
    public void destroyBean() {
        // Free here resources acquired by the session bean
        System.out.println("StudentService Session Bean destroy.");
    	System.out.println("----------------------------------------------------------");        
    } 
    public void createStudent(Student student) {
    	studentDao.createStudent(student);
    }
    public Student findStudentById(Integer id){
    	return studentDao.findStudentById(id);
    }
    public List<Student> findAllStudents() {
    	return studentDao.findAllStudents();
    }
    public Student getStudentByStudentNo(String student_no){
    	return studentDao.getStudentByStudentNo(student_no);
    }
    public double getAverageRating(int student_id){
    	return studentDao.getAverageRating(student_id);
    }
    public List<TeacherReview> getGoodTeacherReviews(int student_id){
    	return studentDao.getGoodTeacherReviews(student_id);
    }
	public List<TeacherReview> getBadTeacherReviews(int student_id){
		return studentDao.getBadTeacherReviews(student_id);
	}
}
