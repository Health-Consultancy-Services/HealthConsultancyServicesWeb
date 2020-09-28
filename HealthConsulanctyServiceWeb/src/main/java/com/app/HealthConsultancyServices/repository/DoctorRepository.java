package com.app.HealthConsultancyServices.repository;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.app.HealthConsultancyServices.model.Doctor;
import com.app.HealthConsultancyServices.model.Patient;
public interface DoctorRepository extends CrudRepository<Doctor, Integer> {
	Doctor findByEmail(String email);
	List<Doctor> findByDepartment(String department);
	List<Doctor> findByStatus(String status);
	
	  @Modifying
	  @Transactional
	  @Query("UPDATE Doctor d SET d.status = 'Permanent' WHERE d.doctor_id = :doctor_id")
	  public int AcceptDoctor(@Param("doctor_id") int doctor_id);
	
	  
}
