
public class Shopper {
	private int items;
	private double arrival;
	
	public Shopper(int i, double d){
		items = i;
		arrival = d;
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
}
