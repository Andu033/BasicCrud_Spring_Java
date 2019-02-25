package com.andu033.restapi.basiccrud.DAO.Impl;

import com.andu033.restapi.basiccrud.DAO.userDAO;
import com.andu033.restapi.basiccrud.models.user;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.stream.Collectors;

public class HibernateUserDAO implements userDAO {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	//resolve this hack
	@Override
	public List<user> getUser(String username) {
		Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
		String hql = "from user";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<user> users = query.list();
		tx.commit();
		//System.out.println(users.size());
		users.stream()
				.forEach(p->System.out.println(p.getUsername()));
		return users.stream()
				.filter(user -> user.getUsername().equals(username))
				.collect(Collectors.toList());
		
	}
	
	@Override
	public void saveUser(user User) {
		Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
		try {
			
			sessionFactory.getCurrentSession().save(User);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}
	}
	
	@Override
	public void deleteUser(user User) {
		Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
		try {
			
			sessionFactory.getCurrentSession().delete(User);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}
	}
}
