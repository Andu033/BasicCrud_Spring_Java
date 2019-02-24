package com.andu033.restapi.basiccrud;

import com.andu033.restapi.basiccrud.DAO.Impl.HibernateUserDAO;

public class Context {
	
	public static HibernateUserDAO userDAO = new HibernateUserDAO();
	
	public static HibernateUserDAO getUserDAO() {
		return userDAO;
	}
	
}
