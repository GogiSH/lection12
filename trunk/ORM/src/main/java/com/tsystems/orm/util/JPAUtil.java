package com.tsystems.orm.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static final String PERSISTENCE_UNIT = "hsql";
	
	private static EntityManagerFactory entityManagerFactory = null;
	private static InheritableThreadLocal<EntityManager> entityManagerThreadLocal = new InheritableThreadLocal<EntityManager>();

	static {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		} catch (Throwable ex) {
			System.err.println("Initial EntityManagerFactory creation failed."	+ ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	/**
	 * Get the configured entityManagerFactory
	 * 
	 * @return entityManagerFactory
	 */
	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	/**
	 * Get entity manager from thread
	 * 
	 * @return entity manager
	 */
	public static EntityManager getEntityManager() {
		if (entityManagerThreadLocal.get() == null || entityManagerThreadLocal.get().isOpen() == false) {
			entityManagerThreadLocal.set(entityManagerFactory
					.createEntityManager());
		}
		return entityManagerThreadLocal.get();
	}
}
