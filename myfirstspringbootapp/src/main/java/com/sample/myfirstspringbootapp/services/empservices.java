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
public class empservices {

	@Autowired
	userRepo userRepository;
	
	
	public Optional<userEntity> getemployeeDetails(int id) {
		return userRepository.findById(id);
		
		
	}
	public void saveEmployee(userEntity user) {
		userRepository.save(user);
		
	}
}
