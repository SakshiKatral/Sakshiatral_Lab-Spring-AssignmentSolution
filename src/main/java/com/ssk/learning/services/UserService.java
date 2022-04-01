package com.ssk.learning.services;

import com.ssk.learning.model.AppUser;

public interface UserService {

	void saveUser(AppUser user);
	public AppUser getUserByUserName(String username);

}