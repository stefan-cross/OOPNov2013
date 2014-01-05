package DLList;

/**
 * User: stefancross
 * Date: 13/12/2013
 * Time: 14:52
 */
public class DNode<E> implements IDNode<E> {

    // Vars
    private DNode<E> next, prev;
    private E element;

    // Constructor
    public DNode(DNode<E> newPrev, DNode<E> newNext, E newElement){
        next = newNext;
        prev = newPrev;
        element = newElement;
    }

    public DNode() {
    }

    // sets element to generic type and returns provided type
    public E element() throws InvalidPlaceException {
        if((next == null) && (prev == null)){
            throw new InvalidPlaceException("Invalid place in list, or list is empty");
        }
        return element;
    }

    // Accessor methods, explained in interface
    public DNode<E> getNext(){
        return next;
    }

    public DNode<E> getPrev(){
        return prev;
    }

    // Modify methods, explained in interface
    public void setNext(DNode<E> newNext){
       this.next = newNext;
    }

    public void setPrev(DNode<E> newPrev){
        this.prev = newPrev;
    }

    public void setElement(E newEl){
        element = newEl;
    }

}
