package com.app.HealthConsultancyServices.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.HealthConsultancyServices.model.Appointment;
import com.app.HealthConsultancyServices.model.Doctor;
import com.app.HealthConsultancyServices.repository.AppointmentRepository;

@Service
@Transactional
public class AppointmentService {
	
	@Autowired
	AppointmentRepository appointmentRepository;
	
	
	public Appointment saveOrUpdate(Appointment appointment)   
	{  
		return appointmentRepository.save(appointment);  
	}  
	
	public int AcceptAppointment(int appointment_id) {
		return appointmentRepository.AcceptAppointment(appointment_id);
	}
	
	public int DeclineAppointment(int appointment_id) {
		return appointmentRepository.DeclineAppointment(appointment_id);
	}
	

}
