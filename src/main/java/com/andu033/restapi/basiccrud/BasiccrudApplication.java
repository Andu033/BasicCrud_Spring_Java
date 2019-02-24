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
		HibernateUserDAO dao = new HibernateUserDAO();
		HibernateUtil.getSessionFactory().openSession();
		dao.setSessionFactory(HibernateUtil.getSessionFactory());
		dao.saveUser(user1);
		dao.saveUser(user1);
		dao.saveUser(user1);
		user1.setId(2);
		//dao.deleteUser(user1);
		dao.getUser("andu").stream()
				.forEach(p->System.out.println(p.getId()));
	}

}
