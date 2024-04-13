package com.components.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
@ResponseBody
public class UserControllerSecure 
{
	@GetMapping("/dashboard")
	public String dashboard()
	{
		return "user_dashboard";
	}
	
	@GetMapping("/about")
	public String about()
	{
		return "user_contact_details";
	}
}
