package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class Controller1 
{
	@RequestMapping("/")
	public String home()
	{
		System.out.println("home page");
		return "home";
	}
	
	@RequestMapping("/contact")
	public String contact()
	{
		System.out.println("contact page");
		return "contact";
	}
	
}
