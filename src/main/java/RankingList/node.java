package RankingList;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 13/12/2013
 * Time: 14:52
 * To change this template use File | Settings | File Templates.
 */
public class Node {

    // Vars
    private Node next;
    private Object element;

    // Constructor
    public Node(Node newNext, Object newElement){
        next = newNext;
        element = newElement;
    }

    public Object element() throws InvalidPlaceException {
        if(next == null){
            throw new InvalidPlaceException("Invalid Place in list");
        }
        return element;
    }

    // Accessor methods
    public Node getNext(){
        return next;
    }

    // Modify methods
    public void setNext(Node newNext){
       this.next = newNext;
    }

}
