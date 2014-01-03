package ImmutableDoubleLinkedList;

import javax.imageio.ImageTranscoder;
import java.util.Enumeration;

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


    public ImmutablePlacement(Iterable<E> list, ImmutablePlacement<E> newPrev, E el, boolean first) throws InvalidPlaceException {
        if(list == null){
            throw new IllegalArgumentException("List is null");
        }
        boolean empty = false;
        if(first){
            empty = list.iterator().hasNext();
        }
        if(!empty){
            element = el;
            next = list.iterator().hasNext() ? new ImmutablePlacement<E>(list, this, getNext().element(), false) : getNext();
            prev = newPrev;
        } else {
            element = element();
            next = null;
            prev = newPrev;
        }
    }

    // sets element to generic type and returns provided type
    public E element() throws InvalidPlaceException {
//TODO reconsider this as it doenst work when rebuilding the front node where el is null
//        if((next == null) && (prev == null)){
//            throw new InvalidPlaceException("Invalid place in list, or list is empty");
//        }
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
