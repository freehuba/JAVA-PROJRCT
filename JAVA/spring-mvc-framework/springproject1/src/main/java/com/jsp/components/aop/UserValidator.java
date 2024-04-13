package com.jsp.components.aop;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import com.jsp.components.exception.InvalidPasswordException;
import com.jsp.components.exception.InvalidUserEmailException;

@EnableAspectJAutoProxy
@Aspect
@Component
public class UserValidator 
{
	@Before("execution(* com.jsp.components.controller.UserController.saveUser(..)) && args(request,..)")
	public void beforeAdvice(JoinPoint joinPoint, HttpServletRequest request)
	{
		String userEmail = request.getParameter("userEmail");
		String userPassword = request.getParameter("userPassword");
		String confirmPassword = request.getParameter("userPassword");
		String gmail = "[a-zA-Z][a-zA-Z0-9_.]*@(gmail|yahoo|redft)?[.]com";
		System.out.println(userEmail + "     "+ userPassword+"      "+confirmPassword);
		
		Pattern p = Pattern.compile(gmail);
		Matcher m = p.matcher(userEmail);
		
		if(m.find() && m.group().equalsIgnoreCase(userEmail))
		{
			System.out.println("valid Email");
		}
		
		else
		{
			System.out.println("inavalid gmail");
			throw new InvalidUserEmailException("Invalid Gmail-Address");
		}
		
		if(userPassword.length()>8 && userPassword.equals(confirmPassword))
		{
			System.out.println("valid password");
		}
		
		else
		{
			System.out.println("inavalid password");
			throw new InvalidPasswordException("Invalid Password ");
		}
		
	}
	
}
