package com.app.HealthConsultancyServices.services;

import java.util.ArrayList;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
import com.app.HealthConsultancyServices.model.Patient;  
import com.app.HealthConsultancyServices.repository.PatientRepository;  
//defining the business logic  
@Service  
public class PatientService   
{  
@Autowired  
PatientRepository patientRepository;  


public List<Patient> getAllPatient()   
{  
List<Patient> patient = new ArrayList<Patient>();  
patientRepository.findAll().forEach(patient1 -> patient.add(patient1));  
return patient;  
}  

public Patient findByEmail(String email)   
{
return patientRepository.findByEmail(email);  
}

public Patient getPatientById(int patient_id)   
{  
return patientRepository.findById(patient_id).get();  
}  
  
public Patient saveOrUpdate(Patient patient)   
{  
	return patientRepository.save(patient);  
}  
 
public void delete(int patient_id)   
{  
	patientRepository.deleteById(patient_id);  
}  
  
public void update(Patient patient, int patientid)   
{  
	patientRepository.save(patient);  
}  
}  
