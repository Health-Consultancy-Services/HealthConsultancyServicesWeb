package com.app.HealthConsultancyServices.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.HealthConsultancyServices.model.User;
import com.app.HealthConsultancyServices.services.UserService;
@Controller
public class LoginController {
	@Autowired
	UserService userService;
	
	@RequestMapping("/loginhome")
	public String loginhome() {
		
		return "login.jsp";
	}
	
	@RequestMapping ("/login-user")
	public String loginUser(@ModelAttribute User user,Model model, HttpServletRequest request) {
		if(userService.findByEmailAndPasswordAndRole(user.getEmail(), user.getPassword(), user.getRole())!=null) {
			return "/dashboard";
		}
		else {
			model.addAttribute("error","Invalid - credintials !!!!!");
			return "/loginhome";
			
		}
	}

}
