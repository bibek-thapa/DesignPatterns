package proxyclasses;

import originalclasses.ConcreteSubject;
import originalclasses.Subject;

public class Proxy  extends Subject{
	
	ConcreteSubject cs;

	@Override
	public void doSomeWork() {
		
		System.out.println("Proxy call is happening now");
		
		if( cs == null ) 
		{
			cs = new ConcreteSubject();
		}
		
		cs.doSomeWork();
			
	}

}
