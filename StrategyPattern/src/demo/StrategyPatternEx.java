package demo;

import java.util.Scanner;

import choices.FirstChoice;
import choices.IChoice;
import choices.SecondChoice;
import contextofchoice.Context;

public class StrategyPatternEx {
	
	/*
	 * Strategy pattern provides dynamic behaviour for us.
	 * it help us to avoid dealing complex algorithm-specific 
	 * data structures
	 * 
	 * Same behaviour can be expressed differently. So users
	 * can have variety of choices
	 * 
	 */
	
	/* Challenges with Strategy Pattern
	 * 
	 * The number of objects are increased in the system
	 * Additional overhead is needed due to communication between
	 * strategies and contexts
	 * Users need to be fully aware of all kinds of possible
	 * behaviors to avoid confusion.
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args) 
	{
		System.out.println("Strategy Design Patterns **");
		String input1, input2;
		String input3;
		Scanner sc = new Scanner(System.in);
		IChoice ic;
		Context ctx = new Context();
		
		for(int i = 1 ; i <=2 ; i++) 
		{
			System.out.println("Enter the first input");
			input1 = sc.nextLine();
			System.out.println("Enter the second input");
			input2 = sc.nextLine();
			System.out.println("Enter the choices");
			input3 = sc.nextLine();
			
			if (input3.equals("1")) 
			{
				ic = new FirstChoice();
			}
			else
				ic = new SecondChoice();
			
			ctx.setIc(ic);
			ctx.showChoice(input1, input2);
			
		}
		
		sc.close();
	}

}
