package DoubleLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * User: stefancross
 * Date: 15/12/2013
 * Time: 15:09
 */
public class ElementIterator<E> implements Iterator<E> {

    protected List<E> list;
    protected IPlacement<E> pointer;

    public ElementIterator(List<E> l) {
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

    @Override
    public boolean hasNext() {
        return pointer != null;
    }

    @Override
    public E next() throws NoSuchElementException{

        E returning = null;
        if(pointer == null){
            throw new NoSuchElementException("There is not a next element");
        }
        try {
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

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Removing items when iterating is not currently supported");
    }
}
