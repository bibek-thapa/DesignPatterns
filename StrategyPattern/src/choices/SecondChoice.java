package choices;

public class SecondChoice implements IChoice{

	@Override
	public void myChoice(String s1, String s2) {
		System.out.println("The result of String Concatenation is ");
		System.out.println(s1+s2);
		System.out.println("End of Strategy pattern");
		
	}

}
