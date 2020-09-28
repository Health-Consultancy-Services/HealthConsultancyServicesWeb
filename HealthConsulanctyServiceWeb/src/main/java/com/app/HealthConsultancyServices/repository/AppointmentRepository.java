package com.app.HealthConsultancyServices.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.app.HealthConsultancyServices.model.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer>{

	@Modifying
	  @Query("UPDATE Appointment a SET a.status = 'accept' WHERE a.appointment_id = :appointment_id")
	  public int AcceptAppointment(@Param("appointment_id") int appointment_id);
	
	@Modifying
	  @Query("UPDATE Appointment a SET a.status = 'decline' WHERE a.appointment_id = :appointment_id")
	  public int DeclineAppointment(@Param("appointment_id") int appointment_id);
	  
}
