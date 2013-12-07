package com.tsystems.lection12.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tsystems.lection12.dao.StudentVelikanovaDao;
import com.tsystems.lection12.entities.Student;
import com.tsystems.lection12.entities.TeacherReview;

@Stateless
public class StudentVelikanovaDaoImpl extends GenericDaoImpl<Student, Integer> implements StudentVelikanovaDao {

	@PersistenceContext(unitName="lection12")
	private EntityManager entityManager;
	
	@PostConstruct
	public void initialize(){
		System.out.println("Bean has been created");
	}
	
	@PreDestroy
	public void destroyBean(){
		System.out.println("Bean has been destroyed");
	}
	
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
		Query query = entityManager.createQuery("from Student where student_no = :student_no");
		query.setParameter("student_no", student_no);
		return (Student) query.getSingleResult();
	}
	
	@Override
	public double getAverageRating(int student_id)
	{
		Query query = entityManager.createQuery("select avg(rating) from TeacherReview where student_id = :student_id");
		query.setParameter("student_id", student_id);
		return (double) query.getSingleResult();
	}

	@Override
	public List<TeacherReview> getGoodTeacherReviews(int student_id) {
		Query query = entityManager.createQuery("from TeacherReview where student_id = :student_id and rating>3");
		query.setParameter("student_id", student_id);
		return (ArrayList<TeacherReview>) query.getResultList();
	}

	@Override
	public List<TeacherReview> getBadTeacherReviews(int student_id) {
		Query query = entityManager.createQuery("from TeacherReview where student_id = :student_id and rating<=3");
		query.setParameter("student_id", student_id);
		return (ArrayList<TeacherReview>) query.getResultList();
	}
}
