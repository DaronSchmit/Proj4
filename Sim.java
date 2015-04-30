import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class Sim{

	public static PQ agenda = new PQ();
	public static int finishTime;
	public static int baggingTime;
	public static Checker[] lanes;
	public static int normLanes = 6;
	public static int expressLanes = 0;
	public static int totLanes = normLanes + expressLanes;

	public static void main(String[] args){ 

		lanes  = new Checker[normLanes + expressLanes];
		finishTime = 20000;
		baggingTime = 9;
		int[] checkers = new int[normLanes + expressLanes];	



		for(int i = 0; i < normLanes+expressLanes; i++){
			if(i < normLanes){
				lanes[i] = new Checker(false);
			}
			else{
				lanes[i] = new Checker(true);
			}
		}

		ShopperMaker first = new ShopperMaker();
		agenda.add(first, 0);
		CheckerEvent ce;



		for(int i = 0; i < normLanes+expressLanes; i++){
			ce = new CheckerEvent(lanes[i]);
			agenda.add(ce,1);
		}//set up the dominoes for each lane

		
		while(agenda.getCurrentTime() < finishTime){
			agenda.remove().run();
		}
		

		System.out.println("Statistics for this trial:");
		System.out.print(finishTime + " second trial with " + normLanes + " lanes, " + expressLanes + " express lanes, and");	
		if(baggingTime == 5){
			System.out.println(" employee Bagging: ");
		}
		else{
			System.out.println(" shopper Bagging: ");
		}

		Checker r = null;
		System.out.println("Each lane's busy time, down time, shoppers served, and items sold: ");
		System.out.println("Lane number  Busy Time  Down Time  Shoppers    Items   Average Wait");

		for(int i = 0; i < totLanes; i++){
			r = lanes[i];
			if(lanes[i].isExpress()){
				System.out.print("Express Lane ");
			}
			else{
				System.out.print("Normal Lane ");
			}

    		System.out.println((i+1) + ":   " + r.getBusyTime() + "      " + r.getDownTime() + "         " + r.getShopperCount() + "       " + r.getItemCount() + "          " + r.getAveTimeWaited());
		}
	}
}