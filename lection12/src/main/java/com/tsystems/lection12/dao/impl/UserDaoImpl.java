package com.tsystems.lection12.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import com.tsystems.lection12.dao.UserDao;
import com.tsystems.lection12.entities.User;

@Stateless
public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements UserDao {

	//Determine Persistence context
    @PersistenceContext(unitName="lection12")
    private EntityManager entityManager;
    
    //Determine transaction manager not necessary - EJB JEE6 do it 
    //EJB to provide us with declarative transaction support.
//    @Inject
//    private UserTransaction utx;
    
    @PostConstruct
    public void initialize () {
        // Initialize here objects which will be used
        // by the session bean
    	System.out.println("----------------------------------------------------------");
        System.out.println("UserDaoImpl initialized.");
    } 

    @PreDestroy
    public void destroyBean() {
        // Free here resources acquired by the session bean
        System.out.println("UserDaoImpl destroy.");
    	System.out.println("----------------------------------------------------------");
    } 
    
	@Override
	public User findUserById(Integer id) {
		return (User) findById(User.class, id);
	}

	@Override
	public User findUserByEmail(String email) {
		Query query = entityManager.createQuery("from User where email = :email");
		query.setParameter("email", email);
		return (User) query.getSingleResult();
	}

	@Override
	public void createUser(User user) {
		save(user);
	}

	@Override
	public List<User> findAllUsers() {
		return findAll(User.class);
	}

	@Override
	public void changeUserPassword(User user, String pass) {
		user.setPassword(pass);
		merge(user);
	}

	public void deleteUserById(Integer id) {
		User user = findUserById(id);
		super.delete(user);
	}

	@Override
	public void deleteUserByEmail(String email) {
		User user = findUserByEmail(email);
		super.delete(user);
	}
	
	
	
}
