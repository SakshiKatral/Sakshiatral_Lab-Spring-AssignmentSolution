package com.ssk.learning.services;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ssk.learning.model.AppUser;

@Service("UserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser appUser = userService.getUserByUserName(username);
		if(appUser != null) {
			Collection<GrantedAuthority> authorities = appUser.getRoles()
					.stream()
					.map(userRole -> new SimpleGrantedAuthority(userRole.getRoleName()))
					.collect(Collectors.toCollection(ArrayList::new));
			return new User(username,appUser.getPassword(),true, true, true, true,authorities);
		}
		else {
			throw  new UsernameNotFoundException("User not found");
		}
	}

}
