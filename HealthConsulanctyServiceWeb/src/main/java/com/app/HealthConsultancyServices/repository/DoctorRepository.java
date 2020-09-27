package com.app.HealthConsultancyServices.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.app.HealthConsultancyServices.model.Doctor;
import com.app.HealthConsultancyServices.model.Patient;
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
	Doctor findByEmail(String email);
	List<Doctor> findByDepartment(String department);

}
