package com.jsp.components.exception;


public class InvalidUserEmailException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	private String str;
	
	public InvalidUserEmailException(String str) 
	{
		this.str = str;
	}
	
	@Override
	public String getMessage()
	{
		return str;
	}
}
