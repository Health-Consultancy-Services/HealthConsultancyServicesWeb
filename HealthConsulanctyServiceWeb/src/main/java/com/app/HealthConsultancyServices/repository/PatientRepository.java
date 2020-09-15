package com.app.HealthConsultancyServices.repository;
import org.springframework.data.repository.CrudRepository;

import com.app.HealthConsultancyServices.model.Patient;
public interface PatientRepository extends CrudRepository<Patient, Integer> {

}
