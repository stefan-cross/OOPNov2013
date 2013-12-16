package DoubleLinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 13/12/2013
 * Time: 14:52
 * To change this template use File | Settings | File Templates.
 */
public class Node<E> implements IPlacement<E> {

    // Vars
    private Node<E> next, prev;
    private E element;

    // Constructor
    public Node(Node<E> newPrev, Node<E> newNext, E newElement){
        next = newNext;
        prev = newPrev;
        element = newElement;
    }

    public E element() throws InvalidPlaceException {
        if((next == null) && (prev == null)){
            throw new InvalidPlaceException("Invalid Place in list");
        }
        return element;
    }

    // Accessor methods
    public Node<E> getNext(){
        return next;
    }

    public Node<E> getPrev(){
        return prev;
    }

    // Modify methods
    public void setNext(Node<E> newNext){
       this.next = newNext;
    }

    public void setPrev(Node<E> newPrev){
        this.prev = newPrev;
    }

    public void setElement(E newEl){
        element = newEl;
    }

}
