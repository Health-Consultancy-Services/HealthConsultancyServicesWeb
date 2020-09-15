package com.app.HealthConsultancyServices.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChangePasswordController {

	@RequestMapping("/changepassword")
	public String changepassword() {
		
		return "changepassword.jsp";
	}
	
}
