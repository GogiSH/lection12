package com.tsystems.orm.dal.impl;

import java.util.List;

import org.hibernate.Query;

import com.tsystems.orm.dal.UserDao;
import com.tsystems.orm.entities.User;
import com.tsystems.orm.util.HibernateUtils;

public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements UserDao {

	@Override
	public User findUserById(Integer id) {
		return (User) findById(User.class, id);
	}

	@Override
	public User findUserByEmail(String email) {
		Query query = HibernateUtils.getSession().createQuery("from User where email = :email");
		query.setString("email", email);
		return (User) query.uniqueResult();
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


	
}
