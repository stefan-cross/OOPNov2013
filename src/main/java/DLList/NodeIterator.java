package DLList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NodeIterator<E> implements Iterator<E> {

    protected List<E> list; // The list we wish to iterate through
    protected INode<E> pointer; // a reference to current progress of iteration

    // Constructor
    public NodeIterator(List<E> l) {
        list = l;
        if(list.isEmpty()){
            pointer = null;
        } else {
            try {
                pointer = list.last();
            } catch (EmptyListException e) {
                e.printStackTrace();
            }
        }
    }
    // returns boolean on pointer
    @Override
    public boolean hasNext() {
        return pointer != null;
    }
    // determine if pointer has a next element
    @Override
    public E next() throws NoSuchElementException{
        E returning = null; // value to be returned
        if(pointer == null){
            throw new NoSuchElementException("There is not a next element");
        }
        try {
            // handle if element is first in list or get next el
            returning = pointer.element();
            if(pointer == list.first()){
                pointer = null;
            } else {
                pointer = list.next(pointer);
            }
        } catch (InvalidPlaceException e) {
            e.printStackTrace();
        } catch (EmptyListException e) {
            e.printStackTrace();
        }
        return returning;
    }
    // remove method not supported but required due to inheritance, so handled as such
    @Override
    public void remove() {
        throw new UnsupportedOperationException("Removing items when iterating is not currently supported");
    }
}
