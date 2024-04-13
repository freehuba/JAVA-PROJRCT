package com.components.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.components.model.User;
import java.util.List;



public interface UserRepository extends JpaRepository<User, Integer>
{
	@Query("select u from User u where u.userEmail = :Email ")
	public User getUserByUserName(@Param("Email") String userEmail);
	
}
