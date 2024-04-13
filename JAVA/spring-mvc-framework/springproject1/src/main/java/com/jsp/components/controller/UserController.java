package com.jsp.components.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.components.exception.InvalidPasswordException;
import com.jsp.components.exception.InvalidUserEmailException;
import com.jsp.components.model.User;
import com.jsp.components.service.UserService;


@Controller
public class UserController 
{
	@Autowired
	private UserService userService;
	
	
	
	//save
	@RequestMapping( value = "/singup",method = RequestMethod.POST)
	public ModelAndView saveUser(HttpServletRequest req,HttpServletResponse res)
	{
		int userId = Integer.parseInt(req.getParameter("userId"));
		String userName = req.getParameter("userName");
		String userPassword = req.getParameter("userPassword");
		String userEmail = req.getParameter("userEmail");
		
		userService.saveUser(userId, userName, userPassword, userEmail);
		
		ModelAndView mView = new ModelAndView();
		mView.addObject("message", "Successufully Inserted..!");
		mView.setViewName("success.jsp");
		return mView;
		
	}
	
}
