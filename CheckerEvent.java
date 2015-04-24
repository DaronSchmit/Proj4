//grabs someone from Checker's Queue
//gets rid of that person
//adds to checker's serve time
//reschedules via run()

public class CheckerEvent implements Event {

	private int serveTime;
	private Checker checker;
	
	CheckerEvent(Checker c){
		checker = c;
		this.serveTime = 0;
	}

	CheckerEvent(Checker c, int st){
		serveTime = st;
		empty = true;
	}

	public void run(){

		Shopper shopper;
		
		if (checker.line.isEmpty()){
			checker.setBusy(false);
		}
		else{
			checker.setBusy(true);
			shopper = (Shopper) checker.line.remove();
			serveTime += shopper.getItems()*5;
		}

		CheckerEvent newEvent = CheckerEvent(checker, serveTime);
	}
	
}