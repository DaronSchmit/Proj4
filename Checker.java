//Each checker will have a line, a boolean to see if it's busy or not, and a boolean for if its an express lane or not.

public class Checker{

	private Q1 line;
	private boolean busy;
	private boolean tenorless;
	private int busyTime;
	private int downTime;


	Checker(boolean express){
		line = new Q1();
		busy = false;
		if(express){
			tenorless = true;
		}
		else{
			tenorless = false;
		}
		int busyTime = 0;
		int downTime = 0;

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

	public Q1 getLine(){
		return line;
	}

	public int getDownTime(){
		return downTime;
	}

	public int getBusyTime(){
		return busyTime;
	}

	public void addDownTime(int dt){
		downTime += dt;
		return;
	}

	public void addBusyTime(int bt){
		busyTime += bt;
	}

}