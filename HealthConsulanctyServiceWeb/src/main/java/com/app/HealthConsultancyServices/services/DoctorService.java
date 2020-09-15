package com.app.HealthConsultancyServices.services;

import java.util.ArrayList;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;

import com.app.HealthConsultancyServices.model.Doctor;
import com.app.HealthConsultancyServices.repository.DoctorRepository;
@Service  
public class DoctorService   
{  
@Autowired  DoctorRepository doctorRepository;  

public List<Doctor> getAllDoctor()   
{  
List<Doctor> doctor = new ArrayList<Doctor>();  
doctorRepository.findAll().forEach(doctor1 -> doctor.add(doctor1));  
return doctor;  
}  
  
public Doctor getDoctorById(int id)   
{  
return doctorRepository.findById(id).get();  
}  
  
public void saveOrUpdate(Doctor doctor)   
{  
	doctorRepository.save(doctor);  
}  
  
public void delete(int id)   
{  
	doctorRepository.deleteById(id);  
}  
  
public void update(Doctor doctor, int doctorid)   
{  
	doctorRepository.save(doctor);  
}  
}  
