//Each checker will have a line and boolean to see if it's busy or not.

public class Checker{

	private Q1 line;
	private boolean busy;
	private boolean tenorless;


	Checker(boolean express){
		line = new Q1();
		busy = false;
		if(!express){
			
		}

	}

	public boolean isBusy(){
		return busy;
	}

	public void setBusy(boolean b){
		busy = b;
		return;
	}

	public boolean isExpress(){
		return tenorless;
	}


}