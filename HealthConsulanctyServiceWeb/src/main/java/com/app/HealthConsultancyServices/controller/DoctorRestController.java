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
import com.app.HealthConsultancyServices.model.User;
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


@GetMapping("/doctor/{doctorid}")  
private Doctor getDoctor(@PathVariable("doctorid") int doctorid)   
{  
return doctorService.getDoctorById(doctorid);  
}  


@DeleteMapping("/doctor/{doctorid}")  
private void deleteDoctor(@PathVariable("doctorid") int doctorid)   
{  
	doctorService.delete(doctorid);  
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
}  
