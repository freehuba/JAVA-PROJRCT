package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller
public class Controller 
{
	@RequestMapping("/home")
	@ResponseBody
	public String Home()
	{
		return "this is home page";
	}
}
