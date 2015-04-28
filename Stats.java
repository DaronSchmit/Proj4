Public class Stats{

    int[] checkers = new int[normLanes + expressLanes];
    for(int i = 0; i < normLanes + expressLanes; i++){
        checkers[i] = lanes[i].total;
    }	
    int[] downtime = new int[normLanes + expressLanes];
    for(int i = 0; i < normLanes + expressLanes; i++){
        downtime[i] =  15000 - lanes[i].total; // modify using time variable once while loop is made in sim
    }	
    
}