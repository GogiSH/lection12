package com.tsystems.orm.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtils {

	private static final SessionFactory sessionFactory;
	// Hibernate 4

	private static ServiceRegistry serviceRegistry;

	static {
		try {
			Configuration configuration = new Configuration();
			// look here what happends!!!
			configuration.configure("/hibernate.cfg.xml");
			serviceRegistry = new ServiceRegistryBuilder().applySettings(
					configuration.getProperties()).buildServiceRegistry();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch (HibernateException ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static Session getSession() {
		Session hibernateSession = sessionFactory.getCurrentSession();
		return hibernateSession;
	}

	public static void beginTransaction() {
		HibernateUtils.getSession().getTransaction().begin();
	}

	public static void commitTransaction() {
		HibernateUtils.getSession().getTransaction().commit();
	}

	public static void rollbackTransaction() {
		HibernateUtils.getSession().getTransaction().rollback();
	}

	public static void closeSession() {
		HibernateUtils.getSession().close();
	}

}
