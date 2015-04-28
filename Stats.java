Public class Stats{

    int[] checkers = new int[normLanes + expressLanes];
    for(int i = 0; i < normLanes + expressLanes; i++){
        checkers[i] = lanes[i].total;
    }

}