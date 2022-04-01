package com.ssk.learning.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssk.learning.model.AppUser;
import com.ssk.learning.model.UserRole;
import com.ssk.learning.services.UserRoleService;
import com.ssk.learning.services.UserService;

@Controller
public class LoginController {
	@Autowired
	UserService userService;

	@Autowired
	UserRoleService userRoleService;

	@Autowired
	PasswordEncoder passwordEncoder;

	@GetMapping("/login")
	public String getLoginPage() {
		return "studentList";
	}

	@GetMapping("/")
	public String login() {
		return "login";
	}

	@PostMapping("/process_login")
	public String getLoginPage1() {
		return "studentList";
	}

	@GetMapping("/signup")
	public String getSignupPage(@ModelAttribute("user") AppUser user) {
		return "signup";
	}

	@GetMapping("/accessDenied")
	public String getaccessDeniedPage() {
		return "accessDenied";
	}
	
	@PostMapping("process-signup")
	public String getProcesssignup(@RequestParam String username, 
			@RequestParam String password, @RequestParam String roleName) {

		UserRole role = userRoleService.getUserRole(roleName);
		System.out.println(role.toString());
		List<UserRole> roles = new ArrayList<>();
		roles.add(role);
		userService.saveUser(new AppUser(username,passwordEncoder.encode(password), roles));
		return "redirect:/";
	}

}
