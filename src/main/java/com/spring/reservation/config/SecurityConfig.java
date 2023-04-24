package com.spring.reservation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.httpBasic().disable();
		http.authorizeRequests()
		
			/* >>>>>>>>>> PAGE <<<<<<<<<< */
			.antMatchers("/account/login", "/account/register")
			.permitAll()
			
			
			/* >>>>>>>>>> API <<<<<<<<<< */
			.antMatchers("/api/account/register", "/api/account/userList")
			.permitAll()
			
			.and()
			.formLogin()
			.usernameParameter("userId")
			.loginPage("/account/login")
			.loginProcessingUrl("/account/login")
			.defaultSuccessUrl("/account/login");
		
	}
}
