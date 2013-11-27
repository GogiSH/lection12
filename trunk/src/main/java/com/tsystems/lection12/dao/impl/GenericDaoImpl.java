package com.tsystems.lection12.dao.impl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.tsystems.lection12.dao.GenericDao;


public abstract class GenericDaoImpl<T, ID extends Serializable> implements GenericDao<T,ID>{
	
	@PersistenceContext(unitName="lection12")
	private EntityManager entityManager;
	
//	@PersistenceUnit(unitName="myPU")  
//	EntityManagerFactory entityManagerFactory;  

	@Override
	public void save(T entity) {
		entityManager.merge(entity);		
	}

	@Override
	public void merge(T entity) {
		entityManager.merge(entity);
	}

	@Override
	public void delete(T entity) {
		entityManager.remove(entity);
	}

	@Override
	public T findById(Class clazz, Integer id) {
		T t = (T) entityManager.find(clazz, id);
		return t;
	}

	@Override
	public List<T> findAll(Class clazz) {
		return (ArrayList<T>) entityManager.createQuery("select x from " + 
				clazz.getCanonicalName() + " x").getResultList();
	}

}
