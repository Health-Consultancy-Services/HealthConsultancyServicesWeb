package com.app.HealthConsultancyServices.services;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<Appointment> findByPatientname(String patientname,String status)   
	{     
	List<Appointment> appointment = new ArrayList<Appointment>();  
	appointmentRepository.findByPatientnameAndStatus(patientname,status).forEach(appointment1 -> appointment.add(appointment1));  
	return appointment; 
	}
	public List<Appointment> findByDoctorname(String doctorname,String status)   
	{     
	List<Appointment> appointment = new ArrayList<Appointment>();  
	appointmentRepository.findByDoctornameAndStatus(doctorname,status).forEach(appointment1 -> appointment.add(appointment1));  
	return appointment; 
	}
	
	public Appointment saveOrUpdate(Appointment appointment)   
	{  
		return appointmentRepository.save(appointment);  
	}  
	
	public int AcceptAppointment(String patientname) {
		return appointmentRepository.AcceptAppointment(patientname);
	}
	
	public int DeclineAppointment(String patientname) {
		return appointmentRepository.DeclineAppointment(patientname);
	}
	

}
