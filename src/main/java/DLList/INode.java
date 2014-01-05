package DLList;

public interface INode<E> {
    // Returns element of type provided
    public E element() throws InvalidPlaceException;
    // Returns placement of next element
    public Node<E> getNext();
    // Returns placement of previous element
    public Node<E> getPrev();
    // Sets the next placement to provided
    public void setNext(Node<E> newNext);
    // Sets the previous placement to provided
    public void setPrev(Node<E> newPrev);
    // Set element to new element
    public void setElement(E newEl);
}
