package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.authentication.PasswordEncoderParser;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.inMemoryAuthentication().
		withUser("admin")
		.password("admin")
		.roles("ADMIN")
		.and()
		.withUser("user")
		.password("user")
		.roles("USER");
		
		//.and() is used as chaining so if you want to user more user pw you need to call and
		
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/jobmanagement").hasRole("ADMIN")
			.antMatchers("/job/add").hasRole("ADMIN")
			.antMatchers("/job/edit/{id}").hasRole("ADMIN")
			.antMatchers("/job/save/{id}").hasRole("ADMIN")
			.antMatchers("/job/delete/{id}").hasRole("ADMIN")
			
			.antMatchers("/machinemanagement").hasRole("ADMIN")
			.antMatchers("/machine/add").hasRole("ADMIN")
			.antMatchers("/machine/edit/{id}").hasRole("ADMIN")
			.antMatchers("/machine/save/{id}").hasRole("ADMIN")
			.antMatchers("/machine/delete/{id}").hasRole("ADMIN")
			
			.antMatchers("/listtimesheetadmin").hasRole("ADMIN")
			.antMatchers("/add_timesheet").hasRole("USER")
			.antMatchers("/list_timesheet").hasRole("USER")
			.antMatchers("/").hasAnyRole("ADMIN","USER")
			.and().formLogin();
		
		

	}

}