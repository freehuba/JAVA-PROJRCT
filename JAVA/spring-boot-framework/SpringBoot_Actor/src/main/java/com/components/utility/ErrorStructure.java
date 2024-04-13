package com.components.utility;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorStructure<T>
{
	private int ststucCode;
	private String errorMessage;
	private T errorData;
	
	public int getStstucCode() {
		return ststucCode;
	}
	public void setStstucCode(int ststucCode) {
		this.ststucCode = ststucCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public T getErrorData() {
		return errorData;
	}
	public void setErrorData(T errorData) {
		this.errorData = errorData;
	}
	
	
}
