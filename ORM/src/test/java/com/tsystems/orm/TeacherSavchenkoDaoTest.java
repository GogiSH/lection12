package com.tsystems.orm;

import java.util.List;
import org.hibernate.HibernateException;
import com.tsystems.orm.dal.TeacherSavchenkoDao;
import com.tsystems.orm.dal.impl.TeacherSavchenkoDaoImpl;
import com.tsystems.orm.entities.Teacher;
import com.tsystems.orm.util.HibernateUtils;

public class TeacherSavchenkoDaoTest {
	
	private static TeacherSavchenkoDao teacherDao = new TeacherSavchenkoDao();
	
	public static void main(String...strings ) {
		try {
			HibernateUtils.beginTransaction();
			
			System.out.println("================================================");
			System.out.println("1) Test (findAllTeachers)");
			List<Teacher> allTeachers = teacherDao.findAllTeachers();
			if (allTeachers.isEmpty()) {
				System.out.println("table Teacher is empty");
				HibernateUtils.rollbackTransaction();
				return;
			}
			
			System.out.println("List of Teachers:");
			for (Teacher tch : allTeachers){
				System.out.println(tch.getId() + " | " + tch.getUser().getLastName() + " " + tch.getUser().getFirstName() + " | " + tch.getExperience());
			}
			System.out.println("================================================");		
			
			System.out.println("2) Test (findTeacherById)");
			Teacher teacher = allTeachers.get(0);	
			System.out.println("Teacher number of "+ teacher.getId() +":");
			teacher = teacherDao.findTeacherById(teacher.getId());
			System.out.println(tch.getId() + " | " + tch.getUser().getLastName() + " " + tch.getUser().getFirstName() + " | " + tch.getExperience());					
			System.out.println("================================================");	
			
			System.out.println("3) Test (getAverageExperience)");
			System.out.println("Average experience of teachers: "+ teacherDao.getAverageExperience());
			System.out.println("================================================");	
			
			System.out.println("4) Test (getMoreExperienceTeacherID)");
			System.out.println("ID teacher, more experience of teachers: "+ teacherDao.getMoreExperienceTeacherID());
			System.out.println("================================================");	
			
						
			
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