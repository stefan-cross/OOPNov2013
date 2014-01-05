package DLList;

public class Node<E> implements INode<E> {

    // Vars
    private Node<E> next, prev;
    private E element;

    // Constructor
    public Node(Node<E> newPrev, Node<E> newNext, E newElement){
        next = newNext;
        prev = newPrev;
        element = newElement;
    }

    public Node() {
    }

    // sets element to generic type and returns provided type
    public E element() throws InvalidPlaceException {
        if((next == null) && (prev == null)){
            throw new InvalidPlaceException("Invalid place in list, or list is empty");
        }
        return element;
    }

    // Accessor methods, explained in interface
    public Node<E> getNext(){
        return next;
    }

    public Node<E> getPrev(){
        return prev;
    }

    // Modify methods, explained in interface
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
