package com.jsp.components.exception;

public class InvalidPasswordException extends RuntimeException
{

	private static final long serialVersionUID = 1L;
	private String str;
	
	public InvalidPasswordException(String str) 
	{
		this.str = str;
	}
	
	@Override
	public String getMessage()
	{
		return str;
	}
}
