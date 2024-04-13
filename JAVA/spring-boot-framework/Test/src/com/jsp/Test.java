package com.jsp;

import java.util.Random;
import java.util.Set;

public class Test 
{
	
	public static void main(String[] args) 
	{
		MakeWrapper m1 = new MakeWrapper(10);
		MakeWrapper m2 = new MakeWrapper(20);
		MakeWrapper m4 = new MakeWrapper(30);
		
		Set<MakeWrapper> s = Set.of(m1, m2, m2,m4,m4);
		s.forEach(e -> System.out.println(((MakeWrapper)e).getValue()));
		
	}
}
