package com.tsystems.lection12.dao;

import java.util.List;

import com.tsystems.lection12.entities.Student;
import com.tsystems.lection12.entities.TeacherReview;
import com.tsystems.lection12.entities.User;

public interface StudentDao extends GenericDao<Student, Integer>  {
	
	void createStudent(Student student);
	void deleteStudent(Student student);
	void setStudentNo(Student student, String studentNo);
	Student findStudentById(Integer id);
	Student findStudentByStudentNo(String studentNo);
	List<Student> findStudentsByUser(User user);
	List<TeacherReview> findTeachersReview();
	List<Student> findAllStudents();
	
}
