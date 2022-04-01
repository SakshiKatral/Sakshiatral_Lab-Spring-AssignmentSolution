package com.ssk.learning.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssk.learning.dao.UserDAO;
import com.ssk.learning.model.AppUser;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDAO userDAO;

	@Override
	public void saveUser(AppUser user) {
		userDAO.saveUser(user);
	}

	@Override
	public AppUser getUserByUserName(String username) {
		System.out.println("getUserByUserName in UserServiceImpl");
		return userDAO.getUserByUserName(username);
	}
}
