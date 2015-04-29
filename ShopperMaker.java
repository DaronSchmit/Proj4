//makes a shopper and assigns it to a lane

import java.util.Random;

public class ShopperMaker implements Event{
	private int numLanes, numExpress, totLanes;
	public ShopperMaker(int lanes, int express){
		numLanes = lanes;
		numExpress = express;
		totLanes = lanes + express;
	}
	
	public double findArrival(){
		double iaRate = 30;
		int distArray[] = new int[100];
		
		for(int i = 0; i < 100; i++){
			distArray[i] = i;
		}
		double result;
		Random generator = new Random();
		int d = generator.nextInt(100);
		if(d < 11){
			result = iaRate + .75 * iaRate;
		}
		else if (d < 26){
			result = iaRate + .5 * iaRate;
		}
		else if (d < 46){
			result = iaRate + .2 * iaRate;
		}
		else if (d < 56){
			result = iaRate;
		}
		else if (d < 76){
			result = iaRate - .2 * iaRate;
		}
		else if (d < 91){
			result = iaRate - .5 * iaRate;
		}
		else{
			result = iaRate - .75 * iaRate;
		}
			
		return result;
	}
	
	public int findItems(){
		int dist[] = new int[] {10,10,10,20,20,20,20,30,30,30,30,30,40,40,40,40,50,50,50,50,60,60,60,70,70,70,80,80,90,100};
		Random generator = new Random();
		int d = generator.nextInt(29);
		int x = dist[d];
		int q = generator.nextInt(9);
		x = x - q;
		return x;
	}

	public Shopper makeShopper(){
		Shopper newShopper = new Shopper(findItems(), findArrival());
		return newShopper;
		
	}

	public void assignShopper(Shopper s){
		int lowest = 1200;
		int bestOption = 0;
		int numItems = s.getItems();
		Checker c = null;
		if(numItems <= 10){ //checking for express lanes first
			for(int i = numLanes; i < totLanes; i++){
				if(Sim.lanes[i].getLine().length() < lowest){
					lowest = Sim.lanes[i].getLine().length();
					bestOption = i;
				}
			}
		}
		else{
			for(int i = numLanes; i < totLanes; i++){
				if(Sim.lanes[i].getLine().length() < lowest){
					lowest = Sim.lanes[i].getLine().length();
					bestOption = i;
				}
			}
		}
		Sim.lanes[bestOption].getLine().add(s);


	}

	public void run(){
		assignShopper(makeShopper());
	}
}
