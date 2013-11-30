package com.tsystems.orm.dal;

import java.util.List;

import com.tsystems.orm.entities.User;

public interface UserDao extends GenericDao<User, Integer> {

	public User findUserById(Integer id);
	public User findUserByEmail(String email);
	public void createUser(User user);
	public List<User> findAllUsers();
	public void changeUserPassword(User user, String pass);

}