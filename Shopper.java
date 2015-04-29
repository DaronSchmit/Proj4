
public class Shopper{
	private int items;
	private double arrival;
	
	public Shopper(int i){
		items = i;
		arrival = Sim.agenda.getCurrentTime();
	}
	
	public Shopper(){}
	
	public void setItems(int i){
		items = i;
	}
	
	public void setArrival(double d){
		arrival = d;
	}
	
	public int getItems(){
		return items;
	}
	
	public double getArrival(){
		return arrival;
	}

	public double getTimeWaited(){
		return Sim.agenda.getCurrentTime() - arrival;
	}
}
