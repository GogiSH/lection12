package com.tsystems.orm.dal.impl;


import java.util.List;

import org.hibernate.Query;

import com.tsystems.orm.dal.StudentDao;
import com.tsystems.orm.entities.Student;
import com.tsystems.orm.util.HibernateUtils;

public class StudentDaoImpl extends GenericDaoImpl<Student, Integer> implements StudentDao {

	@Override
	public Student findStudentById(Integer id) {
		return (Student) findById(Student.class, id);
	}

	@Override
	public void createStudent(Student student) {
		save(student);
	}

	@Override
	public List<Student> findAllStudents() {
		return findAll(Student.class);
	}

	@Override
	public Student getStudentByStudentNo(String student_no) {
		Query query = HibernateUtils.getSession().createQuery("from Student where student_no = :student_no");
		query.setString("student_no", student_no);
		return (Student) query.uniqueResult();
	}
	
	@Override
	public double getAverageRating(int student_id)
	{
		Query query = HibernateUtils.getSession().createQuery("select avg(rating) from TeacherReview where student_id = :student_id");
		query.setInteger("student_id", student_id);
		return (double) query.uniqueResult();
	}
}
