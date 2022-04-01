package com.ssk.learning.dao;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssk.learning.model.AppUser;

@Component
public class UserDAOImpl implements UserDAO{

	SessionFactory sessionFactory;
	Session session;

	@Autowired
	UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try	{
			session = sessionFactory.getCurrentSession();
		}catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
	}
	
	@Override
	@Transactional
	public void saveUser(AppUser user) {
		
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		
	}

	@Override
	@Transactional
	public AppUser getUserByUserName(String username) {
		System.out.println("getUserByUserName in UserDAOImpl");
		
//		Transaction transaction = session.beginTransaction();
		AppUser user = (AppUser) session.createCriteria(AppUser.class)
								.add(Restrictions.eq("username", username))
								.uniqueResult();
//		transaction.commit();
//		System.out.println("getUserByUserName in UserDAOImpl");
		System.out.println(user.toString());
		return user;
	}

}
