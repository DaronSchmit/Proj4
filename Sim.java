public class Sim{

	public static PQ agenda = new PQ();
	public static int finishTime;
	public static Checker[] lanes;

	public static void main(String[] args){ 

		int normLanes = 10;
		int expressLanes = 2;

		lanes  = new Checker[normLanes + expressLanes];
		finishTime = 15000;


		for(int i = 0; i < normLanes+expressLanes; i++){
			if(i < normLanes){
				lanes[i] = new Checker(false);
			}
			else{
				lanes[i] = new Checker(true);
			}
		}

		ShopperMaker first = new ShopperMaker(normLanes, expressLanes);

		for(int i = 0; i < normLanes+expressLanes; i++){
			CheckerEvent ce = new CheckerEvent(lanes[i]);
			agenda.add(ce, ce.getTimeTaken());
		}//set up the dominoes for each lane

		first.run();

		agenda.remove().run();//start the domino

		//while() - we will put stuff here eventually

		System.out.println("Statistics for this trial:");
		System.out.print(finishTime + " second trial with " + normLanes + " lanes, " + expressLanes + " express lanes, and")
		if(baggingTime == 5){
			System.out.println(" employee Bagging: ")
		}
		else{
			System.out.println(" shopper Bagging: ");
		}
		System.out.println("Each lane's downtime is as follows: ");
		for(int i = 0; i < normLanes + expressLanes; i++){
			System.out.println("Lane " + i + ": " + downtime[i]);
		}
	}
}