//Each checker will have a line and boolean to see if it's busy or not.

public class Checker{

	private Q1 line;
	private boolean busy;


	Checker(){
		line = new PQ();
		busy = false;
	}

	public boolean isBusy(){
		return busy;
	}

	public void setBusy(boolean b){
		busy = b;
		return;
	}

}