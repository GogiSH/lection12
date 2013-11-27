package com.tsystems.lection12.dao;

import java.util.List;

import com.tsystems.lection12.entities.User;

public interface UserDao extends GenericDao<User, Integer> {

	public User findUserById(Integer id);
	public User findUserByEmail(String email);
	public void createUser(User user);
	public List<User> findAllUsers();
	public void changeUserPassword(User user, String pass);
	public void deleteUserById(Integer id);
	public void deleteUserByEmail(String email);

}
