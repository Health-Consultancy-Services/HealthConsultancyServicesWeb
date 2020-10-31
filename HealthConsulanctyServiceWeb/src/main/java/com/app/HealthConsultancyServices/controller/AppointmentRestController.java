package com.app.HealthConsultancyServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.HealthConsultancyServices.model.Appointment;
import com.app.HealthConsultancyServices.services.AppointmentService;

@RestController
public class AppointmentRestController {
	
	@Autowired  
	AppointmentService appointmentService; 
	
	@PostMapping("/appointment")  
	private Appointment saveDoctor(@RequestBody Appointment appointment)    
		{  
		Appointment message = null;
	        try {
	            message = appointmentService.saveOrUpdate(appointment);
	        } catch (Exception e) {
	         message = new Appointment();
	        }
	    return message;
	    }  
	
	@GetMapping("/appointmentbypatientname/{patientname}")  
	private List<Appointment> findByPatientname(@PathVariable("patientname") String patientname)   
	{  
	return  appointmentService.findByPatientname(patientname,"inhold");  
	}
	
	@GetMapping("/appointmentbydoctorname/{doctorname}")  
	private List<Appointment> findByDoctorname(@PathVariable("doctorname") String doctorname)   
	{  
	return  appointmentService.findByDoctorname(doctorname,"inhold");  
	} 
	
	
	@GetMapping("/acceptappointment/{appointment_id}")
	public Integer AcceptAppointment(@PathVariable("appointment_id") int appointment_id) {
	Integer result = appointmentService.AcceptAppointment(appointment_id);
		return result;	
		
	}
	
	@GetMapping("/declineappointment/{appointment_id}")
	public Integer DeclineAppointment(@PathVariable("appointment_id") int appointment_id) {
	Integer result = appointmentService.DeclineAppointment(appointment_id);
		return result;	
		
	}

}
