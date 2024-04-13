package com.components.exception;

public class ActorNotFoundByIdException extends RuntimeException 
{
	private static final long serialVersionUID = 1L;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ActorNotFoundByIdException(String message) {
		super();
		this.message = message;
	}
	
	
}
