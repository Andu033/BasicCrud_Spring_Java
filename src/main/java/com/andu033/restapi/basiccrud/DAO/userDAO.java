package com.andu033.restapi.basiccrud.DAO;

import com.andu033.restapi.basiccrud.models.user;

import java.util.List;

public interface userDAO {
	
	List<user> getUser(String username);
	
	//List<user> getAllusers() throws DAOException;
	
	void saveUser(user User);
	
	void deleteUser(user User);
	
	
}
