package com.jsp.application;

interface Hello 
{
	void m1();
	
	default void m2()
	{
		System.out.println("default");
		m4();
	}
	
	static void m3()
	{
		System.out.println("static");
		
	}
	
	private void m4()
	{
		System.out.println("private");
	}
}

class SubHello implements Hello
{
	public static void main(String[] args) 
	{
		Hello h = new SubHello();
		h.m2();
		Hello.m3();
	}

	@Override
	public void m1() {
		
		
	}
}
