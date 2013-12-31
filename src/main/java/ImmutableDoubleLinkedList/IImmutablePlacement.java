package ImmutableDoubleLinkedList;

/**
 * User: stefancross
 * Date: 14/12/2013
 * Time: 12:13
 */

public interface IImmutablePlacement<E> {
    // Returns element of type provided
    public E element() throws InvalidPlaceException;
    // Returns placement of next element
    public ImmutablePlacement<E> getNext();
    // Returns placement of previous element
    public ImmutablePlacement<E> getPrev();
    // Sets the next placement to provided
//    public void setNext(ImmutableImmutablePlacement<E> newNext);
//    // Sets the previous placement to provided
//    public void setPrev(ImmutableImmutablePlacement<E> newPrev);
//    // Set element to new element
//    public void setElement(E newEl);
}
