package com.app.HealthConsultancyServices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.HealthConsultancyServices.model.User;
import com.app.HealthConsultancyServices.services.UserService;
@RestController
public class UserRestController {
	@Autowired
	UserService userService;
	
	//creating post mapping that post the doctor detail in the database  
	@PostMapping("/user")  
	private String saveUser(@RequestBody User user)   
	{  
		userService.saveOrUpdate(user);
		return user.getEmail();  
 
	}  
	//creating put mapping that updates the doctor detail   
	@PutMapping("/user")  
	private User update(@RequestBody User user)   
	{  
		userService.saveOrUpdate(user);   
	return user;  
	} 
	
	@GetMapping("/login/{email}/{password}/{role}")
	public User findByEmailAndPasswordAndRole(@PathVariable("email") String email,@PathVariable("password") String password,@PathVariable("role") String role) {
		return null;
		
	}
}
