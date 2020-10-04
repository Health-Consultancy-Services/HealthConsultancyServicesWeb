package com.app.HealthConsultancyServices.controller;

import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.web.bind.annotation.DeleteMapping;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.PostMapping;  
import org.springframework.web.bind.annotation.PutMapping;  
import org.springframework.web.bind.annotation.RequestBody;  
import org.springframework.web.bind.annotation.RestController;  
import com.app.HealthConsultancyServices.model.Doctor;
import com.app.HealthConsultancyServices.services.DoctorService;  
//mark class as Controller  
@RestController  
public class DoctorRestController   
{  
//autowire the BooksService class  
@Autowired  
DoctorService doctorService;  


@GetMapping("/doctor")  
private List<Doctor> getAllDoctor()   
{  
return doctorService.getAllDoctor();  
}  
@GetMapping("/doctorbyemail/{email}")  
private Doctor findDoctorByEmail(@PathVariable("email") String email)   
{  
return doctorService.findByEmail(email);  
}

@GetMapping("/doctor/{doctorid}")  
private Doctor getDoctor(@PathVariable("doctorid") int doctorid)   
{  
return doctorService.getDoctorById(doctorid);  
}  


@DeleteMapping("/deletedoctor/{doctor_id}")  
private void deleteDoctor(@PathVariable("doctor_id") int doctor_id)   
{  
	doctorService.delete(doctor_id);  
}  


@PostMapping("/doctor")  
private Doctor saveDoctor(@RequestBody Doctor doctor)    
	{  
	Doctor message = null;
        try {
            message = doctorService.saveOrUpdate(doctor);
        } catch (Exception e) {
         message = new Doctor();
        }
    return message;
    }  


@PutMapping("/doctor")  
private Doctor update(@RequestBody Doctor doctor)   
{  
	doctorService.saveOrUpdate(doctor);   
return doctor;  
}  

@GetMapping("/doctorbystatus")  
private List<Doctor> getBYstatus()   
{  
return  doctorService.findByStatus("inhold");  
}  

@GetMapping("/acceptdoctor/{doctor_id}")
public Integer AcceptDoctor(@PathVariable("doctor_id") int doctor_id) {
Integer result = doctorService.AcceptDoctor(doctor_id);
	return result;		
}
@GetMapping("/CountDoctor")
public Integer CountDoctor() {
	Integer result = doctorService.CountDoctor();
	return result;
}
@GetMapping("/CountDoctorByStatus")
public Integer CountDoctorByStatus() {
	Integer result = doctorService.CountDoctorByStatus();
	return result;
}
}  
