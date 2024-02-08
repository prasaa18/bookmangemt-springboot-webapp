package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	private static final String ACTION_1 = "ADMIN";
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		
		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		  http.authorizeRequests().  
	      antMatchers("/index", "/user","/").permitAll()  
	      .antMatchers("/listbooks").hasAnyAuthority(ACTION_1,"USER")
			.antMatchers("/addnew").hasAnyAuthority(ACTION_1)
			.antMatchers("/updatebyid").hasAnyAuthority(ACTION_1)
			.antMatchers("/deletetebyid").hasAuthority(ACTION_1)
	      .antMatchers("/login").authenticated()  
	      .and()  
	      .formLogin()  
	      .loginPage("/login").defaultSuccessUrl("/submit").permitAll()  
	      .and()
			.logout().permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/403");
			
	}
}
