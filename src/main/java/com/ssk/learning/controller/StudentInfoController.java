package com.ssk.learning.controller;

import javax.persistence.GeneratedValue;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssk.learning.model.Student;
import com.ssk.learning.services.StudentServices;

@Controller
public class StudentInfoController {

	@Autowired
	StudentServices studentServices;

	//get all student
	@GetMapping("/studentList")
	public String getAllStudents(Model model) {
		model.addAttribute("student", studentServices.getAllStudents());
		model.addAttribute("title", "Student List");
		return "studentList";
	}

	//update student info
	@GetMapping("/editStudent/{id}")
	public String updateStudentInfo(@PathVariable(value = "id") int id, Model model) {
		Student student = studentServices.getStudentById(id);
		model.addAttribute("student", student);
		return "edit-student";
	}

	//add new student
	@GetMapping("/addStudent")
	public String addStudent() {
		return "student-form";
	}

	//save student 
	@PostMapping("/save") 
	public String saveStudent(@ModelAttribute(name = "save") Student student) {
		studentServices.addStudentInfo(student);
		return "redirect:/studentList";
	}
	
	//update data
	@PostMapping("/editStudent/updateStudent")
	public String updateStudentInfo(@RequestParam int id, @RequestParam String country,
			@RequestParam String name, @RequestParam String department) {
		Student tempStudent = studentServices.getStudentById(id);
		tempStudent.setId(id);
		tempStudent.setName(name);
		tempStudent.setCountry(country);
		tempStudent.setDepartment(department);
		
		studentServices.updateStudentInfo(tempStudent);
		return "redirect:/studentList";
	}
	
	@GetMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable int id) {
		studentServices.deletetudent(id);
		return "redirect:/studentList";
	}

}
