
public class Shopper {
	private int items;
	private int arrival;
	
	public Shopper(int i, int d){
		items = i;
		arrival = d;
	}
	
	public Shopper(){}
	
	public void setItems(int i){
		items = i;
	}
	
	public void setArrival(int d){
		arrival = d;
	}
	
	public int getItems(){
		return items;
	}
	
	public int getArrival(){
		return arrival;
	}
}