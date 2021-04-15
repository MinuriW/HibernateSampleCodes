package com.hcl.user.service;

import com.hcl.user.dao.UserDAO;
import com.hcl.user.dao.UserDAOImpl;
import com.hcl.user.domain.User;

public class UserServiceImpl implements UserService {
	
	private UserDAO userDAO;
	
	

	public UserServiceImpl() {
		super();
		userDAO = new UserDAOImpl();
	}



	@Override
	public Boolean signUpUser(String firstName, String lastName, String email, String password) {

		User user = new User(firstName, lastName, email, password);
		
		return userDAO.insertUser(user);
	}



	@Override
	public Boolean signInUser(String email, String password) {
		User user = userDAO.getUserByEmail(email);
		return user != null && user.getPassword().equals(password);
	}

}
