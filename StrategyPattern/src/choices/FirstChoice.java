package choices;

public class FirstChoice implements IChoice {

	@Override
	public void myChoice(String s1, String s2) {
		int  i1 = Integer.parseInt(s1);
		int i2 = Integer.parseInt(s2);
		int sum;
		
		sum = i1 + i2 ;
		System.out.println("The result of addition is ");
		System.out.println("The sum is "+ sum);
		
		
	}

}
