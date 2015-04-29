// Example 27
// Queue implementation using a linked list of nodes (see N.java)

public class Q1S implements QS {

    // constructor

    public Q1S() {}

    // selectors

    public void add(Shopper o) {

        if (size == 0) {
          front = new NS(o, null);
          rear = front;
        }
        else {
          rear.setNext(new NS(o, null));
          rear = rear.getNext();
        }
        size++;
    }

    public Shopper remove() {

        Shopper answer;

        if (size == 0)
          return null;
        
        answer = front.getData();
        front = front.getNext();
        size--;
        if (size == 0)
          rear = null;
        return answer;
    }

    public int length() {
        return size;
    }

    private int size;
    private NS front;
    private NS rear;

}  // Q1 class

