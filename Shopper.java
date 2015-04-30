
public class Shopper{
	private int items;
	private double arrival;
	
	public Shopper(int i){
		items = i;
		arrival = Sim.agenda.getCurrentTime();
	}
	
	public Shopper(){}
	
	//Sets amount of items as parameter i, taken from ShopperMaker
	public void setItems(int i){
		items = i;
	}
	

	//Sets arrival time as parameter d
	public void setArrival(double d){
		arrival = d;
	}
	
	//Returns number of items
	public int getItems(){
		return items;
	}
	
	//Returns arrival time
	public double getArrival(){
		return arrival;
	}

	//Returns time between arrival and exit
	public double getTimeWaited(){
		return Sim.agenda.getCurrentTime() - arrival;
	}
}
