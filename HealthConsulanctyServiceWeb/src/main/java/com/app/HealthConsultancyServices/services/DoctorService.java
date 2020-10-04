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
  
public Doctor findByEmail(String email)   
{    
return doctorRepository.findByEmail(email); 
}

public List<Doctor> findByDepartment(String department)   
{     
List<Doctor> doctor = new ArrayList<Doctor>();  
doctorRepository.findByDepartment(department).forEach(doctor1 -> doctor.add(doctor1));  
return doctor; 
}

public Doctor getDoctorById(int doctor_id)   
{  
return doctorRepository.findById(doctor_id).get();  
}  
  
public Doctor saveOrUpdate(Doctor doctor)   
{  
	return doctorRepository.save(doctor);  
}  
  
public void delete(int doctor_id)   
{  
	doctorRepository.deleteById(doctor_id);  
}  
  
public void update(Doctor doctor, int doctorid)   
{  
	doctorRepository.save(doctor);  
}

public List<Doctor> findByStatus(String status)   
{     
List<Doctor> doctor = new ArrayList<Doctor>();  
doctorRepository.findByStatus(status).forEach(doctor1 -> doctor.add(doctor1));  
return doctor; 
}
   public int AcceptDoctor(int doctor_id) {
	return doctorRepository.AcceptDoctor(doctor_id);
}
   public int CountDoctor() {
	 return  doctorRepository.CountDoctor();
   }
   
   public int CountDoctorByStatus() {
		 return  doctorRepository.CountDoctorByStatus();
	   }
}  
