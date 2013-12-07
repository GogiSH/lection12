package com.tsystems.lection12.dao;

import java.util.List;

import com.tsystems.lection12.entities.Student;
import com.tsystems.lection12.entities.TeacherReview;

public interface StudentVelikanovaDao extends GenericDao<Student, Integer>{
	public Student findStudentById(Integer id);
	public void createStudent(Student student);
	public List<Student> findAllStudents();
	public Student getStudentByStudentNo(String student_no);
	public double getAverageRating(int student_id);
	public List<TeacherReview> getGoodTeacherReviews(int student_id);
	public List<TeacherReview> getBadTeacherReviews(int student_id);
}
