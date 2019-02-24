package com.andu033.restapi.basiccrud;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static SessionFactory sessionFactory =  new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
}
