package com.hcl.user.service;

public interface UserService {
	
	public Boolean signUpUser(String firstName, String lastName, String email, String password);

	
	public Boolean signInUser(String email, String password);
}
