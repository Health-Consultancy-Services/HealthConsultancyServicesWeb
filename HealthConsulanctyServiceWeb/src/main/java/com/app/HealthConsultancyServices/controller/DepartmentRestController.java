package com.app.HealthConsultancyServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.HealthConsultancyServices.model.Doctor;
import com.app.HealthConsultancyServices.services.DoctorService;

@RestController
public class DepartmentRestController {
	@Autowired  
	DoctorService doctorService; 
	
	@GetMapping("/doctorbydepartment/{department}")  
	private List<Doctor> findByDepartment(@PathVariable("department") String department)   
	{  
	return doctorService.findByDepartment(department);  
	}
}
