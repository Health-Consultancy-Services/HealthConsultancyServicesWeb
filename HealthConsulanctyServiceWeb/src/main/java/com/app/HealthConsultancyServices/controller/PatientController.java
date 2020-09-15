package com.app.HealthConsultancyServices.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.HealthConsultancyServices.services.PatientService;
@Controller
public class PatientController {
	@Autowired  
	PatientService patientService;
	@GetMapping("/show-patient")
	public String getAllPatient(HttpServletRequest request) {
		request.setAttribute("patient", patientService.getAllPatient());
		request.setAttribute("mode", "ALL_USERS");
		return "viewpatient.jsp";
	}
}
