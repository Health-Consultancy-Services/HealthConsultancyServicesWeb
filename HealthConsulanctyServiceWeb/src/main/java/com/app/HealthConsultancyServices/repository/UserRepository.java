package com.app.HealthConsultancyServices.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.app.HealthConsultancyServices.model.User;

public interface UserRepository extends CrudRepository<User, String> {

  public User findByEmailAndPasswordAndRole(String email, String password, String role);
  @Modifying
  @Query("UPDATE User u SET u.password = :newpassword WHERE u.email = :email and u.password = :password")
  public void ChangePassword(@Param("email") String email,@Param("password") String password,@Param("newpassword") String newpassword);
  
@Modifying
@Query("UPDATE User u SET u.password = :password WHERE u.email = :email")
public void ForgotPassword(@Param("email") String email,@Param("password") String password);

}
