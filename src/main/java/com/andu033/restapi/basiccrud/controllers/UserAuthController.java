package com.andu033.restapi.basiccrud.controllers;

import java.util.List;

import com.andu033.restapi.basiccrud.Context;
import com.andu033.restapi.basiccrud.models.user;
import org.apache.catalina.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.hql.internal.ast.tree.SessionFactoryAwareNode;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
class UserAuthController {
	
	
	// Aggregate root
	
	@GetMapping("/util")
	List<user> all() {
		//SessionFactory factory = new Configuration().configure().buildSessionFactory();
		//System.out.println(Context.getUserDAO().getUser("andu").size());
		return Context.getUserDAO().getUser("andu");
	}
	/*
	@PostMapping("/employees")
	Employee newEmployee(@RequestBody Employee newEmployee) {
		return repository.save(newEmployee);
	}
	*/
	// Single item
	
	@PostMapping("/add")
	Boolean add(@RequestBody user user1) {
		System.out.println(user1.getUsername());
		Context.getUserDAO().getUser(user1.getUsername()).stream().forEach(p->System.out.println(p.getUsername()));
		if (Context.getUserDAO().getUser(user1.getUsername()).isEmpty()) {
			Context.getUserDAO().saveUser(user1);
			return true;
		}
		return false;
		
	}
	
	@PutMapping("/{name}")
	String replaceUser(@RequestBody user user1, @PathVariable String name) {
		List<user> users = Context.getUserDAO().getUser(user1.getUsername());
		if (!users.isEmpty())
		{
			users.stream()
					.forEach(user -> {
						Context.getUserDAO().deleteUser(user);
					});
			Context.getUserDAO().saveUser(user1);
			return "SUCCESS";	
		}
		return "FAILED";
	}
	
	@DeleteMapping("/delete")
	void deleteEmployee(@RequestBody user user1) {
		List<user> users = Context.getUserDAO().getUser(user1.getUsername());
		if (!Context.getUserDAO().getUser(user1.getUsername()).isEmpty())
		{   users.stream()
					.forEach(user -> {
						Context.getUserDAO().deleteUser(user);
					});
			System.out.println("deleted");
		}
	}
}