package com.example.demo.service;



import java.util.Arrays;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.entity.UserDTO;
import com.example.demo.repository.UserRepository;


@Service
public class UserServiceImp implements UserService {
   
	
	
public UserServiceImp() {
		super();
		
	}



@Autowired
private BCryptPasswordEncoder passwordEncoder;

@Autowired
	 UserRepository repository;
	

@Override
	
	@Transactional
	public void saveData(UserDTO user) {
	
		User us= new User();
		us.setUsername(user.getUsername());
	 
		us.setPassword(passwordEncoder.encode(user.getPassword()));
	    us.setEmail(user.getEmail());
	   
	  us.setRoles( Arrays.asList(new Role(2, "USER")));
   
	    
	   repository.save(us);
	    
	}
	 


	
	
	public UserServiceImp(UserRepository repository) {
		super();
		this.repository = repository;
	}





	




	

}
