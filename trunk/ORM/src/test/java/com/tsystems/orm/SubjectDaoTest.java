package com.tsystems.orm;

import java.util.List;

import org.hibernate.HibernateException;

import com.tsystems.orm.dal.SubjectDao;
import com.tsystems.orm.dal.impl.SubjectDaoImpl;
import com.tsystems.orm.entities.Subject;
import com.tsystems.orm.util.HibernateUtils;

public class SubjectDaoTest {

	private static SubjectDao subjectDao = new SubjectDaoImpl();

	public static void main(String... strings) {
		try {

			HibernateUtils.beginTransaction();

			List<Subject> allSubjects = subjectDao.findAll(Subject.class);
			for (Subject subject : allSubjects) {
				System.out.println(subject.getName() + " | "
						+ subject.getDescription());
			}
			//wouldn't work ,till i'll not figure out how to rewrite the select query
			
			/*Subject popularSubject = subjectDao.getMostPopularSubject();
			
			System.out.println(popularSubject.getName() + "|" + popularSubject.getDescription() );*/

			HibernateUtils.commitTransaction();

		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			HibernateUtils.rollbackTransaction();
		} finally {
			HibernateUtils.closeSession();
		}
	}


}
