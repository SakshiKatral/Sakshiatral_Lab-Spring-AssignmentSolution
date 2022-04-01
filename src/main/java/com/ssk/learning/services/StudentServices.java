package com.ssk.learning.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssk.learning.dao.StudentDAO;
import com.ssk.learning.model.Student;

@Service
public class StudentServices {

	@Autowired
	StudentDAO studentDAO;

	//get All Student List
	public List<Student> getAllStudents() {
		return studentDAO.getAllStudents();

	}

	//update student info
	public Student getStudentById(int id) {
		return studentDAO.getStudentById(id);
	}

	//add student info
	public void addStudentInfo(Student student) {
		studentDAO.addStudentInfo(student);
	}
	
	public void updateStudentInfo(Student student) {	
		studentDAO.updateStudentInfo(student);
	}
	
	public void deletetudent(int id) {
		studentDAO.deleteStudent(id);
	}

}
