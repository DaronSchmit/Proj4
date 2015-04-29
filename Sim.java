public class Sim{

	public static PQ agenda = new PQ();
	public static int finishTime;
	public static int baggingTime;
	public static Checker[] lanes;
	public static int normLanes = 10;
	public static int expressLanes = 2;
	public static int totLanes = normLanes + expressLanes;

	public static void main(String[] args){ 

		lanes  = new Checker[normLanes + expressLanes];
		finishTime = 5000;

		baggingTime = 5;


		int[] checkers = new int[normLanes + expressLanes];	

		for(int i = 0; i < normLanes+expressLanes; i++){
			if(i < normLanes){
				lanes[i] = new Checker(false);
			}
			else{
				lanes[i] = new Checker(true);
			}
		}

		ShopperMaker first = new ShopperMaker();
		
		agenda.add(first, 0);

		CheckerEvent ce;

		lanes[0].getLine().add(new Shopper(15));

		for(int i = 0; i < normLanes+expressLanes; i++){
			ce = new CheckerEvent(lanes[i]);
			agenda.add(ce,1);
		}//set up the dominoes for each lane

		while(agenda.getCurrentTime() < finishTime){
			agenda.remove().run();
		}


		System.out.println("Statistics for this trial:");
		System.out.print(finishTime + " second trial with " + normLanes + " lanes, " + expressLanes + " express lanes, and");	
		if(baggingTime == 5){
			System.out.println(" employee Bagging: ");
		}
		else{
			System.out.println(" shopper Bagging: ");
		}

		Checker r = null;
		System.out.println("Each lane's busy time, down time, shoppers served, and items sold: ");
		System.out.println("Lane number     Busy Time   Down Time   Shoppers   Items");
		for(int i = 0; i < normLanes; i++){
			r = lanes[i];
			System.out.println("Normal Lane " + (i+1) + ":      " + r.getBusyTime() + "         " + r.getDownTime() + "            " + r.getShopperCount() + "             " + r.getItemCount());
		}
		for(int i = normLanes; i < normLanes + expressLanes; i++){
			System.out.println("Express Lane " + (i+1) + ":     " + r.getBusyTime() + "         " + r.getDownTime() + "            " + r.getShopperCount() + "             " + r.getItemCount());
		}

		/*
		for(int i = 0; i < normLanes + expressLanes; i++){
       		checkers[i] = lanes[i].getServeTime(); //is this an array of the total time served?
    	}	
    	int[] downtime = new int[normLanes + expressLanes]; // array of downtime for each register
    	for(int i = 0; i < normLanes + expressLanes; i++){
        	downtime[i] =  lanes[i].getDownTime(); 
    	}
    	*/
    	//What is this for?

	}
}