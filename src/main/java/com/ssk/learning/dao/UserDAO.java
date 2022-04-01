package com.ssk.learning.dao;

import com.ssk.learning.model.AppUser;

public interface UserDAO {

	public  void saveUser(AppUser user);
	public AppUser getUserByUserName(String username);
}
