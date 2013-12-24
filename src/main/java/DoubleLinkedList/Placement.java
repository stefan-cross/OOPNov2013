package DoubleLinkedList;

/**
 * User: stefancross
 * Date: 13/12/2013
 * Time: 14:52
 */
final public class Placement<E> implements IPlacement<E> {

    // Vars
    final private Placement<E> next, prev;
    final private E element;

    // Constructor
    public Placement(Placement<E> newPrev, Placement<E> newNext, E newElement){
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
    public Placement<E> getNext(){
        return next;
    }

    public Placement<E> getPrev(){
        return prev;
    }


}
