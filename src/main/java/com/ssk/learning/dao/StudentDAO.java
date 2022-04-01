package com.ssk.learning.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssk.learning.model.Student;


@Component
public class StudentDAO {
	SessionFactory sessionFactory;
	Session session;

	@Autowired
	StudentDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try	{
			session = sessionFactory.getCurrentSession();
		}catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
	}
	
	
	@Transactional
	public List<Student> getAllStudents() {
		
		Transaction transaction = session.beginTransaction();
		List<Student> students = session.createQuery("from Student").list();
		transaction.commit();
		return students;
	}

	@Transactional
	public Student getStudentById(int id) {
		Student student = new Student();
		Transaction transaction = session.beginTransaction();
		student = session.get(Student.class, id);
		transaction.commit();
		return student;
	}
	
	@Transactional
	public void addStudentInfo(Student student) {
		Transaction transaction = session.beginTransaction();
		session.save(student);
		transaction.commit();
	}
	
	@Transactional
	public void updateStudentInfo(Student tempStudent) {
		Transaction transaction = session.beginTransaction();
		session.update(tempStudent);
		transaction.commit();
	}
	
	@Transactional 
	public void deleteStudent(int id) {
		Transaction transaction = session.beginTransaction();
		Student student = session.get(Student.class, id);
		session.delete(student);
		transaction.commit();
	}
 

}
