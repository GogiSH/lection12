package com.tsystems.orm;

import java.util.List;

import org.hibernate.HibernateException;

import com.tsystems.orm.dal.SubjectGudkovDao;
import com.tsystems.orm.dal.impl.SubjectGudkovDaoImpl;
import com.tsystems.orm.entities.Subject;
import com.tsystems.orm.util.HibernateUtils;

public class SubjectGudkovDaoTest {

	private static SubjectGudkovDao subjectDao = new SubjectGudkovDaoImpl();

	public static void main(String... strings) {
		try {

			HibernateUtils.beginTransaction();

			List<Subject> allSubjects = subjectDao.findAll(Subject.class);
			System.out.println("The Subjects are:");
			for (Subject subject : allSubjects) {
				System.out.println(subject.getName() + " | "
						+ subject.getDescription());
			}
			System.out
					.println("------------------------------------------------");
			Subject subjectFindId = subjectDao.findById(Subject.class, 7);
			try {
				System.out.println("Subject number " + subjectFindId.getId()
						+ " is " + subjectFindId.getName());
			} catch (NullPointerException npe) {
				System.out.println("No such subject");

			}

			System.out
					.println("------------------------------------------------");
			Subject popularSubject = subjectDao.getMostPopularSubject();

			System.out.println("The most popular subject is: "
					+ popularSubject.getName());

			HibernateUtils.commitTransaction();

		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			HibernateUtils.rollbackTransaction();
		} finally {
			HibernateUtils.closeSession();
		}
	}

}
