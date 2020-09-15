package com.app.HealthConsultancyServices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.app.HealthConsultancyServices.model.User;
import com.app.HealthConsultancyServices.services.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
}
