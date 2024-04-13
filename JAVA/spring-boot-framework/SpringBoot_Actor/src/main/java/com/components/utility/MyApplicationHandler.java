package com.components.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.components.exception.ActorNotFoundByIdException;

@RestControllerAdvice
public class MyApplicationHandler 
{
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> actorNotFoundByIdException(ActorNotFoundByIdException ex)
	{
		ErrorStructure<String> errorStructure = new ErrorStructure<>();
		errorStructure.setStstucCode(HttpStatus.NOT_FOUND.value());
		errorStructure.setErrorMessage(ex.getMessage());
		errorStructure.setErrorData("Actor Object With the given id doesn't exist");
		return new ResponseEntity<ErrorStructure<String>>(errorStructure,HttpStatus.NOT_FOUND);
	}
}
