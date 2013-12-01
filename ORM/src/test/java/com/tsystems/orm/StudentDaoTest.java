package com.tsystems.orm;

import java.util.List;
import org.hibernate.HibernateException;
import com.tsystems.orm.dal.StudentDao;
import com.tsystems.orm.dal.impl.StudentDaoImpl;
import com.tsystems.orm.entities.Student;
import com.tsystems.orm.util.HibernateUtils;

public class StudentDaoTest {
	private static StudentDao studentDao = new StudentDaoImpl();
	public static void main(String...strings ) {
		try {
			HibernateUtils.beginTransaction();
			
			System.out.println("Test1 (findAllStudents)");
			List<Student> allStudents = studentDao.findAllStudents();
			if (allStudents.isEmpty()) {
				System.out.println("Test1: no students selected");
				HibernateUtils.rollbackTransaction();
				return;
			}
			System.out.println("List of students:");
			for (Student st : allStudents){
				System.out.println(st.getStudentNo() + " | " + st.getUser().getLastName());
			}
			Student student = allStudents.get(0);
			
			System.out.println("Test2 (findStudentById)");
			System.out.println("Student number of the first one:");
			int stud_id = student.getId();
			Student returned = studentDao.findStudentById(stud_id);
			String student_no = returned.getStudentNo();
			System.out.println(student_no);
			
			System.out.println("Test3 (getStudentByStudentNo)");
			System.out.println("His surname:");
			Student samestudent = studentDao.getStudentByStudentNo(student_no);

			System.out.println(samestudent.getUser().getLastName());
			
			System.out.println("Test4 (getAverageRating)");
			System.out.println("Average rating for student: " + studentDao.getAverageRating(stud_id));
			
			HibernateUtils.commitTransaction();

		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			HibernateUtils.rollbackTransaction();
		} catch (NullPointerException exc){
			System.out.println(exc.getMessage());
			HibernateUtils.rollbackTransaction();
		} finally {
			HibernateUtils.closeSession();
		}
	}
}
