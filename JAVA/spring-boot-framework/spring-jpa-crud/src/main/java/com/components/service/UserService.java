package com.components.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.components.model.User;
import com.components.repository.UserRepository;

@Service
public class UserService 
{
	@Autowired
	private UserRepository userRepository;
	
	public User save(User user)
	{
		return userRepository.save(user);
	}	
	
}
