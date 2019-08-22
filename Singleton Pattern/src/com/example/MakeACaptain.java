package com.example;

public class MakeACaptain {
	
	private static MakeACaptain _captain;
	
	private MakeACaptain() {}
	
	
	public static MakeACaptain getCaptain() 
	{
		/*
		 * This is lazy initialization because until the getCaptain is called
		 * the _captain object is not made
		 */
		if(_captain == null) 
		{
			/*
			 * Object is made over here so it is lazy initialization
			 */
			_captain = new MakeACaptain();
			System.out.println("New captain is made");
		}
		else 
		{
			System.out.println("Captain is already available");
		}
		
		return _captain;
	}
	
	

}
