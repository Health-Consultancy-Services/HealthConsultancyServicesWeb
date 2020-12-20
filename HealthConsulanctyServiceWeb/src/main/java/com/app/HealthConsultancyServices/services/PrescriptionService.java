package com.app.HealthConsultancyServices.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.HealthConsultancyServices.model.Prescription;
import com.app.HealthConsultancyServices.repository.PrescriptionRepository;

@Service 
public class PrescriptionService {
	@Autowired PrescriptionRepository prescriptionRepository;
	
	public List<Prescription> getAllPrescription()   
	{  
	List<Prescription> prescription = new ArrayList<Prescription>();  
	prescriptionRepository.findAll().forEach(prescription1 -> prescription.add(prescription1));  
	return prescription;  
	} 
	
	public Prescription getPrescriptionById(int prescriptionid)   
	{  
	return prescriptionRepository.findById(prescriptionid).get();  
	}  
	  
	public Prescription saveOrUpdate(Prescription prescription)   
	{  
		return prescriptionRepository.save(prescription);  
	}  
	  
	public void delete(int prescriptionid)   
	{  
		prescriptionRepository.deleteById(prescriptionid);  
	}  
	  
	public void update(Prescription prescription, int prescriptionid)   
	{  
		prescriptionRepository.save(prescription);  
	}
	
	public List<Prescription> findByPatientname(String patientname)   
	{     
	List<Prescription> prescription = new ArrayList<Prescription>();  
	prescriptionRepository.findByPatientname(patientname).forEach(prescription1 -> prescription.add(prescription1));  
	return prescription; 
	}
	
	public List<Prescription> findByDoctorname(String doctorname)   
	{     
	List<Prescription> prescription = new ArrayList<Prescription>();  
	prescriptionRepository.findByDoctorname(doctorname).forEach(prescription1 -> prescription.add(prescription1));  
	return prescription; 
	}
}
