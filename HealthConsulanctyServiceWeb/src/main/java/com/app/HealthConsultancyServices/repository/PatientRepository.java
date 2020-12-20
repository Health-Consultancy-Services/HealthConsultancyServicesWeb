package com.app.HealthConsultancyServices.repository;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.app.HealthConsultancyServices.model.Patient;
public interface PatientRepository extends CrudRepository<Patient, Integer> {
	Patient findByEmail(String email);
	Patient findByPatientname(String patientname);
	
	@Transactional
	  @Query("SELECT COUNT(p.patient_id) FROM Patient p")
	  public int CountPatient();
}
