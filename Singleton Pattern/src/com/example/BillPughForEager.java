package com.example;

public class BillPughForEager {
	/*
	 * Using the eager way the MakeACaptain had to be instantiated always
	 * but using BillPughForEager way it is not the case.
	 * 
	 */
	private static BillPughForEager _captain;
	
	private BillPughForEager() {}
	
	private static class Singletonhelper 
	{
		private static final BillPughForEager _captain = new BillPughForEager();
	}
	
	public static BillPughForEager getCaptain() 
	{
		return Singletonhelper._captain;
		
	
	}
	
	
	

}
