package com.ssk.learning.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.ssk.learning.security.CustomAccessDeniedHandler;


@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;
	@Bean
	public AccessDeniedHandler accessDeniedHandler(){
	    return new CustomAccessDeniedHandler();
	}
	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	};

	
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/editStudent/{id}","/deleteStudent/{id}","/editStudent/updateStudent")
			.hasAuthority("ADMIN")
		.antMatchers("/addStudent","/editStudent/updateStudent","/studentList","/save")
			.hasAnyAuthority("USER", "ADMIN")
		.and()
		.formLogin().loginPage("/")
			.loginProcessingUrl("/process_login")
			.defaultSuccessUrl("/studentList")
			.permitAll()
		.and()
		.exceptionHandling()
			.accessDeniedHandler(accessDeniedHandler())
		.and()
		.logout()
		.and()
		.cors()
		.and()
		.csrf()
		.disable();
	}

}
