//grabs someone from Checker's Queue
//gets rid of that person
//adds to checker's serve time
//reschedules via run()

public class CheckerEvent implements Event {

	public int serveTime;
	private Checker checker;
	private Shopper shopper;

	
	CheckerEvent(Checker c){
		checker = c;
		serveTime = 0;
		if(checker.getLine().isEmpty()){
			shopper = new Shopper(0);
		}
		else{
			shopper = checker.getLine().remove();
			//System.out.println(shopper.getItems());		
		}
	}

	CheckerEvent(Checker c, int st){
		checker = c;
		serveTime = st;
		if(checker.getLine().isEmpty()){
			shopper = new Shopper(0);
		}
		else{
			shopper = checker.getLine().remove();
			//System.out.println(shopper.getItems());		
		}
	}

	public int getTimeTaken(){
		if(shopper == null){
			return 0;
		}
		else{
			return shopper.getItems()*Sim.baggingTime;
		}
	}

	public void run(){
		CheckerEvent newEvent = new CheckerEvent(checker, serveTime);
		if (shopper.getItems() == 0){
			checker.setBusy(false);
			checker.addDownTime(1);
			Sim.agenda.add(newEvent, 1);
		}
		else{
			checker.setBusy(true);
			checker.addBusyTime(getTimeTaken());
			checker.addShopperCount(1);
			checker.addItemCount(shopper.getItems());
			checker.addTimeWaited(shopper.getTimeWaited());
			Sim.agenda.add(newEvent, getTimeTaken());
		}
		//System.out.println("CheckerEvent at " + Sim.agenda.getCurrentTime());

	}
	
}