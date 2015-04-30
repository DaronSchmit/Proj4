//Each checker will have a line, a boolean to see if it's busy or not, and a boolean for if its an express lane or not.
//keeps trach of Busy and Down time, Items taken, Shoppers Served

public class Checker{

	private Q1S line;
	private boolean busy;
	private boolean tenorless;
	private int busyTime;
	private int downTime;
	private int serveTime;
	private int shopperCount;
	private int itemCount;
	private double timeWaited;

	Checker(boolean express){
		timeWaited = 0;
		line = new Q1S();
		busy = false;
		if(express){
			tenorless = true;
		}
		else{
			tenorless = false;
		}
		busyTime = 0;
		downTime = 0;
		itemCount = 0;
		shopperCount = 0;

	}

	//Following methods are getters and setters as while as long term status booleans and record keepers for final print out

	public boolean isBusy(){
		return busy;
	}

	public void addTimeWaited(double n){
		timeWaited += n;
	}

	public double getWaited(){
		return timeWaited;
	}

	public void setBusy(boolean b){
		busy = b;
		return;
	}

	public boolean isExpress(){
		return tenorless;
	}

	public Q1S getLine(){
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

	public void setServeTime(int st){
		serveTime = st;
	}

	public int getServeTime(){
		return serveTime;
	}

	public void addShopperCount(int s){
		shopperCount += s;
	}

	public int getShopperCount(){
		return shopperCount;
	}

	public void addItemCount(int i){
		itemCount += i;
	}

	public int getItemCount(){
		return itemCount;
	}

	public int getAveTimeWaited(){
		double toReturn = timeWaited / shopperCount;
		int y = (int)Math.round(toReturn);
		return y;
	}
}