import java.util.Random;

public class ShopperMaker implements Event{
	private int numLanes, numExpress;
	public ShopperMaker(int lanes, int express){
		numLanes = lanes;
		numExpress = express;
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

	public void makeShopper(){
		Shopper newShopper = new Shopper(findItems, findArrival);
		
	}

	public void assignShopper(){
		int lowest = 1200;
		int bestOption;
		for(int i = 0; i < Sim.lanes - express; i++){
			if(Sim.lanes[i] < lowest){
				bestOption = i;
			}
		}
		Sim.lanes[bestOption].getLine().add(newShopper);


	}

	public void run(){
		makeShopper();
		assignShopper();
		run();

	}
}
