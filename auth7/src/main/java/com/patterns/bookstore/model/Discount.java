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
		
		/*	private Discount() 
	{
		discountCode.add("softwarepatterns10");
		discountCode.add("softwarepatterns20");
		discountCode.add("softwarepatterns30");
	}
	
	public static Discount getInstance()
	{
		return discount;
	}
	
	public double calculatePrice(String code)
	{
		double discount = 0;
		
		for (String e : discountCode)
		{
			if (code.equals(e) && e.equals("Discount1010"))
			{
				discount =  .2;
				break;	
			}
			if (code.equals(e) && e.equals("NewMember"))
			{
				discount =  .25;
				break;	
			}
			if (code.equals(e) && e.equals("LongfordBookClub"))
			{
				discount =  .3;
				break;	
			}
			else 
			{
				discount = 1;
			}
			
		}
			*/
	}
	
	
}