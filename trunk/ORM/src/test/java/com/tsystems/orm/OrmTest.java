package com.tsystems.orm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.tsystems.orm.util.JPAUtil;
import com.tsystems.orm.entities.User;

public class OrmTest {
	
	private static final String PERSISTENCE_UNIT_NAME = "hsql";
	private static EntityManagerFactory factory;
	
	public static void main (String... strings) {
		
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    EntityManager entityManager = factory.createEntityManager();
	    
	    User dummyUser = generateNewUser();
	    
	    try {
	    	//Begin persist
	    	EntityTransaction trx = entityManager.getTransaction();
	    	trx.begin();
			
//			entityManager.persist(dummyUser);
//			entityManager.remove(entityManager.merge(dummyUser));
	    	trx.commit();
			
			//Query users 
			Query query = entityManager.createQuery("select u from User u");
			
			List<User> userList = query.getResultList();
			
			for (User u : userList) {
				System.out.println("User name: " + u.getFirstName() + " User email: " + u.getEmail());
			}
//			
			//Query users via Criteria
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<User> cq = cb.createQuery(User.class);
			Root<User> user = cq.from(User.class);
			cq.select(user);
			TypedQuery<User> q = entityManager.createQuery(cq);
			List<User> allUsers = q.getResultList();
			for (User u : userList) {
				System.out.println("User name: " + u.getFirstName() + " User email: " + u.getEmail());
			}
//			
			Query query2 = entityManager.createQuery("select u from User u WHERE u.id = :id");
			query2.setParameter("id", 101);
			User user101 = (User) query2.getSingleResult();
			System.out.println(user101.getStudents().size());			

	    } catch (PersistenceException ex) {
			if (entityManager.getTransaction().isActive()) {
				//Rollback transaction if exception
				entityManager.getTransaction().rollback();
			}
			System.out.println(ex.getMessage()); 
	    } finally {
			//Close entity manager (the same for Hibernate session)
			entityManager.close();
	    }

	}
	
	private static User generateNewUser () {
		User userEntity = new User();
		userEntity.setEmail("some.user@gmail.de");
		userEntity.setBirthday(new Date());
		userEntity.setFirstName("Some");
		userEntity.setLastName("User");
		userEntity.setPassword("12345");
		
		return userEntity;
	}

}
