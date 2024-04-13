package com.jsp.application;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) 
	{
		List<Integer> al = new ArrayList<Integer>();
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(4);
		
		System.out.println(al);
		al.remove(1);
		System.out.println(al);

	}

}
