package DLList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NodeIterator<E> implements Iterator<E> {

    protected List<E> list; // The list we wish to iterate through
    protected INode<E> ref; // a reference to current progress of iteration

    // Constructor
    public NodeIterator(List<E> l) {
        list = l;
        if(list.isEmpty()){
            ref = null;
        } else {
            try {
                ref = list.last();
            } catch (EmptyListException e) {
                e.printStackTrace();
            }
        }
    }
    // returns boolean on pointer
    @Override
    public boolean hasNext() {
        return ref != null;
    }
    // determine if pointer has a next element
    @Override
    public E next() throws NoSuchElementException{
        E returning = null; // value to be returned
        if(ref == null){
            throw new NoSuchElementException("There is not a next element");
        }
        try {
            // handle if element is first in list or get next el
            returning = ref.element();
            if(ref == list.first()){
                ref = null;
            } else {
                ref = list.next(ref);
            }
        } catch (InvalidPlaceException e) {
            e.printStackTrace();
        } catch (EmptyListException e) {
            e.printStackTrace();
        }
        return returning;
    }
    // remove method not supported
    @Override
    public void remove() {
        throw new UnsupportedOperationException("Removing items when iterating is not currently supported");
    }
}
