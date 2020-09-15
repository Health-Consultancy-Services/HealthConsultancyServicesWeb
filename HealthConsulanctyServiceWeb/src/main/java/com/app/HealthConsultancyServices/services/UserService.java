package com.app.HealthConsultancyServices.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.HealthConsultancyServices.model.User;
import com.app.HealthConsultancyServices.repository.UserRepository;
@Service
@Transactional
public class UserService {
	@Autowired 
	UserRepository userRepository;
	public User findByEmailAndPasswordAndRole(String email, String password,String role) {
		return userRepository.findByEmailAndPasswordAndRole(email, password, role);
	}
	
	public User findByPassword(String password) {
		return userRepository.findByPassword(password);
	}

	public void saveOrUpdate(User user)   
	{  
		userRepository.save(user);  
	}

	public void update(User user, String email)   
	{  
		userRepository.save(user);  
	}
}
