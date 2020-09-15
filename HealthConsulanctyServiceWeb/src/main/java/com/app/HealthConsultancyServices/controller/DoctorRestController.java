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
//creating a get mapping that retrieves all the doctor detail from the database   
@GetMapping("/doctor")  
private List<Doctor> getAllDoctor()   
{  
return doctorService.getAllDoctor();  
}  
//creating a get mapping that retrieves the detail of a specific doctor  
@GetMapping("/doctor/{doctorid}")  
private Doctor getDoctor(@PathVariable("doctorid") int doctorid)   
{  
return doctorService.getDoctorById(doctorid);  
}  
//creating a delete mapping that deletes a specified doctor 
@DeleteMapping("/doctor/{doctorid}")  
private void deleteDoctor(@PathVariable("doctorid") int doctorid)   
{  
	doctorService.delete(doctorid);  
}  
//creating post mapping that post the doctor detail in the database  
@PostMapping("/doctor")  
private int saveDoctor(@RequestBody Doctor doctor)   
{  
	doctorService.saveOrUpdate(doctor);  
return doctor.getDoctor_id();  
}  
//creating put mapping that updates the doctor detail   
@PutMapping("/doctor")  
private Doctor update(@RequestBody Doctor doctor)   
{  
	doctorService.saveOrUpdate(doctor);   
return doctor;  
}  
}  
