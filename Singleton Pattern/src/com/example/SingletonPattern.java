package com.example;

public class SingletonPattern {

	public static void main(String[] args) {

		
		System.out.println("***Singleton Pattern Demo***\n");
		System.out.println("Trying to make a captain for our team");
		BillPughForEager c1 = BillPughForEager.getCaptain();
		System.out.println("Trying to make another captain for our team");
		 BillPughForEager c2 = BillPughForEager.getCaptain();
		String res = (c1 == c2 )? "Same instance" : "Diff instance";
		System.out.println(res);
		 
	}

}
