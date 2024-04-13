package com.components.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.components.model.User;
import com.components.service.UserService;

@Controller
@ResponseBody
public class UserController 
{
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping(path = "/save")
	public User saveUser(@ModelAttribute User user)
	{
		user.setRole("ROLE_USER");
		user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
		System.out.println(user);
		return userService.save(user);
	
	}
	
	@GetMapping(path = "/about")
	public String about()
	{
		return "about web application";
	}
	
	@GetMapping(path = "/contact")
	public String contact()
	{
		return "contact application";
	}
}
