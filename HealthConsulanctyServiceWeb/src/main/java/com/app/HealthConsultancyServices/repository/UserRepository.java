package com.app.HealthConsultancyServices.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.app.HealthConsultancyServices.model.User;

public interface UserRepository extends CrudRepository<User, String> {

  public User findByEmailAndPasswordAndRole(String email, String password, String role);

public User findByPassword(String password);

   }
