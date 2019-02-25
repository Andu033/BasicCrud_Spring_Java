package com.andu033.restapi.basiccrud;

import com.andu033.restapi.basiccrud.DAO.Impl.HibernateUserDAO;
import org.hibernate.SessionFactory;

public class Context {
	
	private static HibernateUserDAO userDAO = new HibernateUserDAO();
	
	public static void setSessionFactory(SessionFactory sessionFactory)
	{
		userDAO.setSessionFactory(sessionFactory);
	}
	
	public static HibernateUserDAO getUserDAO() {
		return userDAO;
	}
	
}
