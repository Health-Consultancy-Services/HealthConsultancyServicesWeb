package com.app.HealthConsultancyServices.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.app.HealthConsultancyServices.model.Prescription;

public interface PrescriptionRepository extends CrudRepository<Prescription, Integer> {
	List<Prescription> findByDoctorname(String doctorname);
	List<Prescription> findByPatientname(String patientname);
}
