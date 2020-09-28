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

import com.app.HealthConsultancyServices.model.Patient;
import com.app.HealthConsultancyServices.model.User;
import com.app.HealthConsultancyServices.services.PatientService; 
//mark class as Controller  
@RestController  
public class PatientRestController   
{  
//autowire the BooksService class  
@Autowired  
PatientService patientService;  


@GetMapping("/patient")  
private List<Patient> getAllPatient()   
{  
return patientService.getAllPatient();  
}  
@GetMapping("/patientbyemail/{email}")  
private Patient findByEmail(@PathVariable("email") String email)   
{  
return patientService.findByEmail(email);  
}
@GetMapping("/patient/{patientid}")  
private Patient getPatient(@PathVariable("patientid") int patientid)   
{  
return patientService.getPatientById(patientid);  
}  

@DeleteMapping("/patient/{patient_id}")  
private void deletePatient(@PathVariable("patient_id") int patient_id)   
{  
	patientService.delete(patient_id);
}  

@PostMapping("/patient")  
private Patient savePatient(@RequestBody Patient patient)   
{  
	Patient message = null;
    try {
        message = patientService.saveOrUpdate(patient);
    } catch (Exception e) {
     message = new Patient();
    }
return message;
}


@PutMapping("/patient")  
private Patient update(@RequestBody Patient patient)   
{  
	patientService.saveOrUpdate(patient);   
return patient;  
}  
}  
