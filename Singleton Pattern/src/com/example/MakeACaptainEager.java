package com.example;

public class MakeACaptainEager {
	
	private static MakeACaptainEager _captain = new MakeACaptainEager();
	private MakeACaptainEager() {}
	
	public static MakeACaptainEager getCaptain() 
	{
		return _captain;
		
	
	}
}
