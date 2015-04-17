//grabs someone from Checker's Queue
//gets rid of that person
//adds to checker's serve time
//reschedules via run()

public class CheckerEvent implements Event {

	private int serveTime;
	
	CheckerEvent(){
		serveTime = 0;
	}

	CheckerEvent(int st){
		serveTime = st;
		line = new PQ();
		empty = true;
	}

	public void run(){

		
		CheckerEvent newEvent = CheckerEvent(serveTime);
	}
	
}