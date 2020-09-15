package com.app.HealthConsultancyServices.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.HealthConsultancyServices.services.DoctorService;

@Controller
public class DoctorController {
	@Autowired  
	DoctorService doctorService; 
	
	@GetMapping("/show-doctor")
	public String getAllDoctor(HttpServletRequest request) {
		request.setAttribute("doctor", doctorService.getAllDoctor());
		request.setAttribute("mode", "ALL_USERS");
		return "viewdoctor.jsp";
	}
	@RequestMapping("/delete-user")
	public String delete(@RequestParam int doctor_id, HttpServletRequest request) {
		doctorService.delete(doctor_id);
		request.setAttribute("doctor", doctorService.getAllDoctor());
		request.setAttribute("mode", "ALL_USERS");
		return "viewdoctor.jsp";
	}
}
