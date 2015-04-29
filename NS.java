// N.java
// A *simplified* node class for use with the Stack1 class 
// and other uses as desired
// Posted previously, but used for simulation

public class NS {
  
    // constructors
    
    public NS() {}

    public NS(Shopper o, NS link) {
        data = o;
        next = link;
    }

    // selectors

    public Shopper getData() {
        return data;
    }

    public void setData(Shopper o) {
        data = o;
    }

    public NS getNext() {
        return next;
    }

    public void setNext(NS link) {
        next = link;
    }

    // instance variables

    private Shopper data;
    private NS next;

}  // N class
