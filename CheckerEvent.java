//grabs someone from Checker's Queue
//gets rid of that person
//adds to checker's serve time
//reschedules via run()

public class CheckerEvent implements Event {

	public int serveTime;
	private Checker checker;
	private Shopper shopper;
	private int baggingTime;

	
	CheckerEvent(Checker c){
		checker = c;
		serveTime = 0;
		shopper = getShopper();
		baggingTime = 5;
	}

	CheckerEvent(Checker c, int st){
		checker = c;
		shopper = getShopper();
		baggingTime = 5; 
	}

	private Shopper getShopper(){
		return (Shopper) checker.getLine().remove();
	}

	public int getTimeTaken(){
		return shopper.getItems()*baggingTime;
	}

	public void run(){

		if (shopper == null){
			checker.setBusy(false);
		}
		else{
			checker.setBusy(true);
		}

		if(serveTime < Sim.finishTime){
			CheckerEvent newEvent = new CheckerEvent(checker, serveTime);
			Sim.agenda.add(newEvent, newEvent.getTimeTaken()); //add a domino
		}//Doesn't add if it is at
	}
	
}