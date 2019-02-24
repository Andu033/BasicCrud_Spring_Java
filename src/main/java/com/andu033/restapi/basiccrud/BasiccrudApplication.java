package com.andu033.restapi.basiccrud;

import com.andu033.restapi.basiccrud.DAO.Impl.HibernateUserDAO;
import com.andu033.restapi.basiccrud.models.user;
import org.hibernate.Hibernate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class BasiccrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasiccrudApplication.class, args);
		user user1 = new user("andu","password","dcuan17@yahoo.com");
		HibernateUtil.getSessionFactory().openSession();
		Context.getUserDAO().setSessionFactory(HibernateUtil.getSessionFactory());
		//dao.deleteUser(user1);
		Context.getUserDAO().getUser("andu").stream()
				.forEach(p->System.out.println(p.getId()));
	}

}
