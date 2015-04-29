public class Sim{

	public static PQ agenda = new PQ();
	public static int finishTime;
	public static int baggingTime;
	public static Checker[] lanes;

	public static void main(String[] args){ 

		int normLanes = 10;
		int expressLanes = 2;

		lanes  = new Checker[normLanes + expressLanes];
		finishTime = 15000;


		int[] checkers = new int[normLanes + expressLanes];	

		for(int i = 0; i < normLanes+expressLanes; i++){
			if(i < normLanes){
				lanes[i] = new Checker(false);
			}
			else{
				lanes[i] = new Checker(true);
			}
		}

		ShopperMaker first = new ShopperMaker(normLanes, expressLanes);

		CheckerEvent ce;

		for(int i = 0; i < normLanes+expressLanes; i++){
			ce = new CheckerEvent(lanes[i]);
			agenda.add(ce, ce.getTimeTaken());
		}//set up the dominoes for each lane

		first.run();

		agenda.remove().run();//start the domino

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
		System.out.println("Each lane's downtime: ");
		for(int i = 0; i < normLanes; i++){
			System.out.println("Normal Lane " + i+1 + ": " + lanes[i].getDownTime());
		}
		for(int i = normLanes; i < normLanes + expressLanes; i++){
			System.out.println("Express Lane" + (i+1) + ": " + lanes[i].getDownTime());
		}

		System.out.println("Each lane's total shoppers served: ");
		for(int i = 0; i < normLanes; i++){
			System.out.println("Normal Lane " + i+1 + ": " + lanes[i].getShopperCount());
		}
		for(int i = normLanes; i < normLanes + expressLanes; i++){
			System.out.println("Express Lane" + (i+1) + ": " + lanes[i].getShopperCount());
		} 
		*/

		/*
		for(int i = 0; i < normLanes + expressLanes; i++){
       		checkers[i] = lanes[i].getServeTime(); //is this an array of the total time served?
    	}	
    	int[] downtime = new int[normLanes + expressLanes]; // array of downtime for each register
    	for(int i = 0; i < normLanes + expressLanes; i++){
        	downtime[i] =  lanes[i].getDownTime(); 
    	}
    	*/
    	//What is this for??

	}
}