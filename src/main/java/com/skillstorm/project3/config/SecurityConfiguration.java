package com.skillstorm.project3.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	
//	@Autowired
//	private DataSource datasource; // make sure this is from javax.sql!!!
//	
//	@Autowired // This give me bcrypt
//	private EncryptionConfiguration encoder;
	
@Override
protected void configure(HttpSecurity http)throws Exception {
	
//	http.httpBasic();
//	
//	//http.csrf().csrfTokenRepository()
//	http.authorizeHttpRequests().mvcMatchers("/**").authenticated();
//	http.authorizeHttpRequests().mvcMatchers("logout").permitAll();
}
}
