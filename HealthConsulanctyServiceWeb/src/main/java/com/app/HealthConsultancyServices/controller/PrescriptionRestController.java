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

import com.app.HealthConsultancyServices.model.Prescription;
import com.app.HealthConsultancyServices.services.PrescriptionService;

@RestController  
public class PrescriptionRestController {
	@Autowired PrescriptionService prescriptionService;
	@GetMapping("/prescription")  
	private List<Prescription> getAllPrescription()   
	{  
	return prescriptionService.getAllPrescription();  
	}  
	@GetMapping("/prescription/{prescriptionid}")  
	private Prescription getPrescription(@PathVariable("prescriptionid") int prescriptionid)   
	{  
	return prescriptionService.getPrescriptionById(prescriptionid);  
	}  


	@DeleteMapping("/deleteprescription/{prescriptionid}")  
	private void deletePrescription(@PathVariable("prescriptionid") int prescriptionid)   
	{  
		prescriptionService.delete(prescriptionid);  
	}  


	@PostMapping("/prescription")  
	private Prescription savePrescription(@RequestBody Prescription prescription)    
		{  
		Prescription message = null;
	        try {
	            message = prescriptionService.saveOrUpdate(prescription);
	        } catch (Exception e) {
	         message = new Prescription();
	        }
	    return message;
	    }  


	@PutMapping("/prescription")  
	private Prescription update(@RequestBody Prescription prescription)   
	{  
		prescriptionService.saveOrUpdate(prescription);   
	return prescription;  
	}  
	
	@GetMapping("/prescriptionforpatient/{patientname}")  
	private List<Prescription> findByPrescriptionPatientname(@PathVariable("patientname") String patientname)   
	{  
	return prescriptionService.findByPatientname(patientname);  
	}
	
	@GetMapping("/prescriptionbydoctor/{doctorname}")  
	private List<Prescription> findByPrescriptionDoctorname(@PathVariable("doctorname") String doctorname)   
	{  
	return prescriptionService.findByDoctorname(doctorname);  
	}

}
