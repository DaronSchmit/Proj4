// Queue Interface

public interface QS {

// Interface for a Queue

    void add(Shopper o);

    /* adds an Shopper o to a queue placing it in the order of arrival 
       relative to other items added to the queue--first in, first out
       (FIFO) */

    Shopper remove();
 
    /* removes and returns the object placed in a queue prior
       to any other items presently in the queue */

    int length();

    /* returns the integer quantity of items currently present in the 
       queue */ 

}  // Q Interface
