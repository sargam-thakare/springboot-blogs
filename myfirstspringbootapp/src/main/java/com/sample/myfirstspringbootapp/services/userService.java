package com.sample.myfirstspringbootapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sample.myfirstspringbootapp.Entity.Employee;
import com.sample.myfirstspringbootapp.Entity.userEntity;
 import com.sample.myfirstspringbootapp.repository.userRepo;
 

 
@Component
@Service
public class userService {

	@Autowired
	userRepo userRepository;
	
	
	public Optional<userEntity> getUserDetails(int id) {
		return userRepository.findById(id);
		
		
	}
	public void saveUser(userEntity user) {
		userRepository.save(user);
		
	}
	
	public userEntity findUserWithNameandPassword(String username,String password) {
	userEntity user=userRepository.findByNameAndPassword(username, password)     ;
	System.out.println("user  findUserWithNameandPassword "+user);
		return user;
	}
}
