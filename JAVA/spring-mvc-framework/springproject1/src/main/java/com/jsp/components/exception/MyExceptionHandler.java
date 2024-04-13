package com.jsp.components.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class MyExceptionHandler 
{
	@ExceptionHandler(InvalidUserEmailException.class)
	public ModelAndView exceptionHandlerUserEmail()
	{
		ModelAndView m = new ModelAndView();
		m.addObject("message","Invalid Gmail-Address Exception");
		m.setViewName("null_error.jsp");
		return m;
	}
	
	@ExceptionHandler(InvalidPasswordException.class)
	public ModelAndView exceptionHandlerUserPassword()
	{
		ModelAndView m = new ModelAndView();
		m.addObject("message","Invalid Password Exception");
		m.setViewName("null_error.jsp");
		return m;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView genericExceptionHandler()
	{
		ModelAndView m = new ModelAndView();
		m.addObject("message","Exception has occured");
		m.setViewName("null_error.jsp");
		return m;
	}
}
