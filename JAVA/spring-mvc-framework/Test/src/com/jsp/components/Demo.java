package com.jsp.components;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo 
{
	public static void main(String[] args) 
	{
		
		String gmail4 = "[a-zA-Z][a-zA-Z0-9_.]*@(gmail|yahoo|redft)?[.]com";
		String str= "hemanthjm@gmail.com";
		String pwd = "flowe";
		
		Pattern p = Pattern.compile(gmail4);
		Matcher m = p.matcher(str);
		
		if(m.find() && m.group().equalsIgnoreCase(str))
		{
			System.out.println("valid"+m.group());
		}
		
		else
		{
			System.out.println("Invalid");
		}
		
		if(pwd.length()>8)
		{
			System.out.println("valid password" + pwd.length());
		}
		
		else
		{
			System.out.println("invalid password");
		}
	}
}
