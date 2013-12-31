package ImmutableDoubleLinkedList;

/**
 * User: stefancross
 * Date: 13/12/2013
 * Time: 14:52
 */
public class ImmutablePlacement<E> implements IImmutablePlacement<E> {

    // Vars
    private final ImmutablePlacement<E> next, prev;
    private final E element;

    // Constructor
    public ImmutablePlacement(ImmutablePlacement<E> newPrev, ImmutablePlacement<E> newNext, E newElement){
        next = newNext;
        prev = newPrev;
        element = newElement;
    }

    // sets element to generic type and returns provided type
    public E element() throws InvalidPlaceException {
        if((next == null) && (prev == null)){
            throw new InvalidPlaceException("Invalid place in list, or list is empty");
        }
        return element;
    }

    // Accessor methods, explained in interface
    public ImmutablePlacement<E> getNext(){
        return next;
    }

    public ImmutablePlacement<E> getPrev(){
        return prev;
    }

    // Modify methods, explained in interface
//    public void setNext(Placement<E> newNext){
//       this.next = newNext;
//    }
//
//    public void setPrev(Placement<E> newPrev){
//        this.prev = newPrev;
//    }
//
//    public void setElement(E newEl){
//        element = newEl;
//    }

}
