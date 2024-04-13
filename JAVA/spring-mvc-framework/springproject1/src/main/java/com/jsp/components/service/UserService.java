package com.jsp.components.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.components.model.User;
import com.jsp.components.repository.UserRepository;


@Service
public class UserService 
{
	@Autowired
	private UserRepository userRepository;
	
	public void saveUser(int userId,String userName,String userPassword,String userEmail)
	{
		User user = new User();   
		user.setUserId(userId);
		user.setUserName(userName);
		user.setUserPassword(userPassword);
		user.setUserEmail(userEmail);
		
		userRepository.saveUser(user);
		
	}
}
