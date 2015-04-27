public class Sim{

	public static void main(String[] args){

		public static agenda = new PQ(); 

		int normLanes = 10;
		int expressLanes = 2;
		int finishTime = 10000;

		static Checker[] lanes = Checker[normLanes + expressLanes];

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

		while()

		//print stats here once we get to that
	}
}