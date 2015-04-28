//grabs someone from Checker's Queue
//gets rid of that person
//adds to checker's serve time
//reschedules via run()

public class CheckerEvent implements Event {

	public int serveTime;
	private Checker checker;
	private Shopper shopper;
	public int total;
	public int timeTaken;
	public int baggingTime;

	
	CheckerEvent(Checker c){
		checker = c;
		serveTime = 0;
		shopper = getShopper();
		timeTaken = shopper.getItems()*baggingTime;
	}

	CheckerEvent(Checker c, int totals){
		total = totals;
		checker = c;
		empty = true;
		shopper = getShopper(); 
		timeTaken = shopper.getItems()*baggingTime;
	}

	private Shopper getShopper(){
		return (Shopper) checker.getLine().remove();
	}

	public void run(){

		if (shopper == null){
			checker.setBusy(false);
		}
		else{
			checker.setBusy(true);
			total += timeTaken;
		}

		if(serveTime < Sim.finishTime){
			CheckerEvent newEvent = CheckerEvent(checker, total);
			Sim.agenda.add(newEvent, timeTaken); //add a domino
		}//Doesn't add if it is at
	}
	
}