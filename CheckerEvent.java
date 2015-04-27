//grabs someone from Checker's Queue
//gets rid of that person
//adds to checker's serve time
//reschedules via run()

public class CheckerEvent implements Event {

	private int serveTime;
	private Checker checker;
	private Shopper shopper;

	
	CheckerEvent(Checker c){
		checker = c;
		serveTime = 0;
		shopper = getShopper();
		timeTaken = shopper.getItems()*5;
	}

	CheckerEvent(Checker c, int st){
		checker = c;
		serveTime = st;
		empty = true;
		shopper = getShopper(); 
		timeTaken = shopper.getItems()*5;
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
			serveTime += timeTaken;
		}

		if(serveTime < Sim.finishTime){
			CheckerEvent newEvent = CheckerEvent(checker, serveTime);
			agenda.add(newEvent, timeTaken); //add a domino
		}//Doesn't add if it is at
	}
	
}