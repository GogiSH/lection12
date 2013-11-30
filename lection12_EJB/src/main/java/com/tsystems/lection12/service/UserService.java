package com.tsystems.lection12.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.tsystems.lection12.dao.UserDao;
import com.tsystems.lection12.entities.User;

@Stateless
public class UserService {
	
	//Injecting UserDAO by CDI
	@Inject
	private UserDao userDao;
	
    @PostConstruct
    public void initialize () {
        // Initialize here objects which will be used
        // by the session bean
    	System.out.println("----------------------------------------------------------");
        System.out.println("UserService Session Bean initialized.");
    } 

    @PreDestroy
    public void destroyBean() {
        // Free here resources acquired by the session bean
        System.out.println("UserService Session Bean destroy.");
    	System.out.println("----------------------------------------------------------");        
    } 

	/**
	 * Create a new user or update an existing one
	 * 
	 * @param User user
	 */
    public void createUser(User user) {
    	userDao.createUser(user);
    }
    
	/**
	 * Find a user
	 * 
	 * @param Integer id identifier of the user to be retrieved
	 * 
	 * @return User user represented by the identifier provided
	 */
    public User findUserById(Integer id) {
    	return userDao.findUserById(id);
    }
    
	/**
	 * Find a user by email
	 * 
	 * @param String email
	 * 
	 * @return User user represented by the email provided
	 */
    public User findUserByEmail(String email) {
    	return userDao.findUserByEmail(email);
    }
    
	/**
	 * Find all users in database
	 * 
	 * @return ArrayList<User> of users 
	 */
    public List<User> findAllUsers() {
    	return userDao.findAllUsers();
    }
    
	/**
	 * Change an user password
	 * 
	 * @param User user
	 * @param String pass
	 */
    public void changeUserPassword(User user, String pass) {
    	userDao.changeUserPassword(user, pass);
    }
    
	
	/**
	 * Delete user from data store
	 * 
	 * @param Integer id
	 */
    public void deleteUserById(Integer id) {
    	userDao.deleteUserById(id);
    }
    
	/**
	 * Delete user from data store
	 * 
	 * @param String email
	 */
    public void deleteUserById(String email) {
    	userDao.deleteUserByEmail(email);
    }
}
