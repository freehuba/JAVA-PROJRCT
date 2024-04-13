package com.components.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.components.model.User;

public interface UserRepo extends JpaRepository<User, String>
{
	
}
