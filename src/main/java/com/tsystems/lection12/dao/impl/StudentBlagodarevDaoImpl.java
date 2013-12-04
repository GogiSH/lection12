package com.tsystems.lection12.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tsystems.lection12.dao.StudentBlagodarevDao;
import com.tsystems.lection12.entities.Student;
import com.tsystems.lection12.entities.TeacherReview;
import com.tsystems.lection12.entities.User;

@Stateless
public class StudentBlagodarevDaoImpl extends GenericDaoImpl<Student, Integer> implements StudentBlagodarevDao {

	@PersistenceContext(name="lection12")
	private EntityManager entityManager;
	
	@PostConstruct
	public void initialize(){
		System.out.println("---------------------------------");
		System.out.println("Bean has been created");
	}
	
	@PreDestroy
	public void destroyBean(){
		System.out.println("---------------------------------");
		System.out.println("Bean has been destroyed");
	}
	
	@Override
	public void createStudent(Student student) {
		save(student);		
	}

	@Override
	public void deleteStudent(Student student) {
		delete(student);
		
	}

	@Override
	public void setStudentNo(Student student, String studentNo) {
		student.setStudentNo(studentNo);
		merge(student);		
	}

	@Override
	public Student findStudentById(Integer id) {
		return findById(Student.class, id);
	}

	@Override
	public Student findStudentByStudentNo(String studentNo) {
		Query query = entityManager.createQuery("from Student where student_no = :studentNo");
		query.setParameter("studentNO", studentNo);
		return (Student) query.getSingleResult();
	}

	@Override
	public List<Student> findStudentsByUser(User user) {
		Query query = entityManager.createQuery("from Student where user_id = :userId");
		query.setParameter("userId", user.getId());
		return query.getResultList();
	}

	@Override
	public List<TeacherReview> findTeachersReview(Student student) {
		Query query = entityManager.createQuery("from Teacher_review where student_id = :studentId");
		query.setParameter("studentId", student.getId());
		return query.getResultList();
	}

	@Override
	public List<Student> findAllStudents() {
		return findAll(Student.class);
	}
	

}
