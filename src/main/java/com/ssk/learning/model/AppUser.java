package com.ssk.learning.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class AppUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, unique = true)
	private String username;
	
	@Column(nullable = false, unique = true)
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<UserRole> roles;

	public AppUser(String username, String password, List<UserRole> roles) {
		this.username = username;
		this.password = password;
		this.roles = roles;
	}
	
	
}
