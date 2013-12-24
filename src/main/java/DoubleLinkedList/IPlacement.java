package DoubleLinkedList;

/**
 * User: stefancross
 * Date: 14/12/2013
 * Time: 12:13
 */

public interface IPlacement<E> {
    // Returns element of type provided
    public E element() throws InvalidPlaceException;
    // Returns placement of next element
    public Placement<E> getNext();
    // Returns placement of previous element
    public Placement<E> getPrev();
}
