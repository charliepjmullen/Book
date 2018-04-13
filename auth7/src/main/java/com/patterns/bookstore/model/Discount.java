package com.patterns.bookstore.model;

import java.util.ArrayList;
import java.util.List;

//Singleton Pattern Object
public class Discount {
	
	static List<String> discountCode = new ArrayList<String>();
	
	static boolean correctCode = false;
	
	private static Discount discount = new Discount();
	
	private Discount() 
	{
		discountCode.add("softwarepatterns10");
		discountCode.add("softwarepatterns20");
		discountCode.add("softwarepatterns30");
	}
	
	public static Discount getInstance()
	{
		return discount;
	}
	
	public boolean calculatePrice(String code)
	{
		for (String e : discountCode)
		{
			if (code.equals(e))
			{
				correctCode = true;
				break;
				
			}
			
		}
	
		return correctCode;
		
	}
	
	
}