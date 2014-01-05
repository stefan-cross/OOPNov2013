package DLList;

/**
 * User: stefancross
 * Date: 14/12/2013
 * Time: 12:13
 */

public interface IDNode<E> {
    // Returns element of type provided
    public E element() throws InvalidPlaceException;
    // Returns placement of next element
    public DNode<E> getNext();
    // Returns placement of previous element
    public DNode<E> getPrev();
    // Sets the next placement to provided
    public void setNext(DNode<E> newNext);
    // Sets the previous placement to provided
    public void setPrev(DNode<E> newPrev);
    // Set element to new element
    public void setElement(E newEl);
}
