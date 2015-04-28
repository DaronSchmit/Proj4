public class Sim{

	public static PQ agenda = new PQ();
	public static int finishTime;
	public static Checker[] lanes;

	public static void main(String[] args){ 

		lanes  = Checker[normLanes + expressLanes];
		finishTime = 10000;
		int normLanes = 10;
		int expressLanes = 2;
		baggingTime = 5;  // user selects whether employees bag or shoppers bag; this needs to be set in CheckerEvent, otherwise it throws an error


		for(int i = 0; i < normLanes+expressLanes; i++){
			if(i < normLanes){
				lanes[i] = new Checker(false);
			}
			else{
				lanes[i] = new Checker(true);
			}
		}

		ShopperMaker first = new ShopperMaker(normLanes, expressLanes);
		first.run();

		for(int i = 0; i < lanes.length(); i++){
			agenda.add(CheckerEvent(lanes[i]),CheckerEvent.serveTime);
		}

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