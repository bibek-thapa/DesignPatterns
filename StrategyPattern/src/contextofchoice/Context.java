package contextofchoice;

import choices.IChoice;

public class Context {
	private IChoice ic;

	public IChoice getIc() {
		return ic;
	}

	public void setIc(IChoice ic) {
		this.ic = ic;
	}
	
	public void showChoice(String s1 , String s2) 
	{
		ic.myChoice(s1, s2);
	}
	

}
