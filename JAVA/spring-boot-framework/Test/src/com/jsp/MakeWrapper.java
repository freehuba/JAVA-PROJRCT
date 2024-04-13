package com.jsp;

import java.util.Objects;

public class MakeWrapper 
{
	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public MakeWrapper(int value) {
		super();
		this.value = value;
	}

	@Override
	public String toString() {
		return "MakeWrapper [value=" + value + "]";
	}

	@Override
	public boolean equals(Object obj) {
		return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hashCode(10);
	}
	
	
}
