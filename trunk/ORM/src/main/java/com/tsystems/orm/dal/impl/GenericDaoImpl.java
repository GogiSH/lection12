package com.tsystems.orm.dal.impl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.tsystems.orm.dal.GenericDao;
import com.tsystems.orm.util.HibernateUtils;


public abstract class GenericDaoImpl<T, ID extends Serializable> implements GenericDao<T,ID>{

	@Override
	public void save(T entity) {
		HibernateUtils.getSession().saveOrUpdate(entity);		
	}

	@Override
	public void merge(T entity) {
		HibernateUtils.getSession().merge(entity);
	}

	@Override
	public void delete(T entity) {
		HibernateUtils.getSession().delete(entity);
	}

	@Override
	public T findById(Class clazz, Integer id) {
		T t = (T) HibernateUtils.getSession().get(clazz, id);
		return t;
	}

	@Override
	public List<T> findAll(Class clazz) {
		Query query = HibernateUtils.getSession().createQuery("from " + clazz.getSimpleName());
		return (ArrayList<T>) query.list();
	}

}
