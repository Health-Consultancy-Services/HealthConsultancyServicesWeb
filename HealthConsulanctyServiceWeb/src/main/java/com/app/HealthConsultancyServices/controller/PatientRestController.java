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
import com.app.HealthConsultancyServices.services.PatientService; 
//mark class as Controller  
@RestController  
public class PatientRestController   
{  
//autowire the BooksService class  
@Autowired  
PatientService patientService;  
//creating a get mapping that retrieves all the patient detail from the database   
@GetMapping("/patient")  
private List<Patient> getAllPatient()   
{  
return patientService.getAllPatient();  
}  
//creating a get mapping that retrieves the detail of a specific patient  
@GetMapping("/patient/{patientid}")  
private Patient getPatient(@PathVariable("patientid") int patientid)   
{  
return patientService.getPatientById(patientid);  
}  
//creating a delete mapping that deletes a specified patient 
@DeleteMapping("/patient/{patientid}")  
private void deletePatient(@PathVariable("patientid") int patientid)   
{  
	patientService.delete(patientid);  
}  
//creating post mapping that post the patient detail in the database  
@PostMapping("/patient")  
private int savePatient(@RequestBody Patient patient)   
{  
	patientService.saveOrUpdate(patient);  
return patient.getPatient_id();  
}  
//creating put mapping that updates the student detail   
@PutMapping("/patient")  
private Patient update(@RequestBody Patient patient)   
{  
	patientService.saveOrUpdate(patient);   
return patient;  
}  
}  
