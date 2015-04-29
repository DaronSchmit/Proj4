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


	Checker(boolean express){
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
}