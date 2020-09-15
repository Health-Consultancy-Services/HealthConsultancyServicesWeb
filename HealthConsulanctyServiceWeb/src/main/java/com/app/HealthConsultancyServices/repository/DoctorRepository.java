package com.app.HealthConsultancyServices.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.app.HealthConsultancyServices.model.Doctor;
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

}
