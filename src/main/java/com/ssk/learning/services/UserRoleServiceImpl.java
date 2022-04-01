package com.ssk.learning.services;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.ssk.learning.model.UserRole;

@Service
public class UserRoleServiceImpl implements UserRoleService {

	HibernateTemplate hibernateTemplate;
	
	@Autowired
	UserRoleServiceImpl(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public UserRole getUserRole(String role) {
		System.out.println(role);
		UserRole userRole = new UserRole();
		if (role.equalsIgnoreCase("admin")) {
			userRole.setRoleName("ADMIN");
		}
		else if(role.equalsIgnoreCase("user")) {
			userRole.setRoleName("USER");
		}
		hibernateTemplate.save(userRole);
		System.out.println(userRole.toString());
		return userRole;
	}
}


