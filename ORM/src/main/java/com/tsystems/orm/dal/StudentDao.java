package com.tsystems.orm.dal;

import java.util.List;

import com.tsystems.orm.dal.GenericDao;
import com.tsystems.orm.entities.Student;

public interface StudentDao extends GenericDao<Student, Integer>{
	public Student findStudentById(Integer id);
	public void createStudent(Student student);
	public List<Student> findAllStudents();
	public Student getStudentByStudentNo(String student_no);
	public double getAverageRating(int student_id);
}