package com.hcl.user.dao;

import com.hcl.user.domain.User;

public interface UserDAO {
	public Boolean insertUser(User user);
	
	public User getUserByEmail(String email);
}
