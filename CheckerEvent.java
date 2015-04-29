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
		shopper = getShopper();
	}

	CheckerEvent(Checker c, int st){
		checker = c;
		serveTime = st;
		shopper = getShopper();
	}

	private Shopper getShopper(){
		return (Shopper) checker.getLine().remove();
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
		if (shopper == null){
			checker.setBusy(false);
			checker.addDownTime(1);
		}
		else{
			checker.setBusy(true);
			checker.addBusyTime(getTimeTaken());
			checker.addShopperCount(1);
		}

		if(serveTime < Sim.finishTime){
			CheckerEvent newEvent = new CheckerEvent(checker, serveTime);
			Sim.agenda.add(newEvent, newEvent.getTimeTaken()); //add a domino
		}//Doesn't add if time is up
		else{
			checker.setServeTime(serveTime);
		}
	}
	
}