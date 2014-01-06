package Stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackIterator<E> implements Iterator<E> {

    protected ImStack<E> stack; // The stack we wish to iterate through
    protected ImStack<E> ref; // a reference to current progress of iteration

    // Constructor
    public StackIterator(ImStack<E> s) {
        stack = s;
        if(stack.isEmpty()){
            ref = null;
        } else {
            ref = stack;
        }
    }
    // returns boolean on pointer
    @Override
    public boolean hasNext() {
        return ref != null;
    }
    // determine if pointer has a next element
    @Override
    public E next() throws NoSuchElementException {
        E returning = null; // value to be returned
        try {
           if(ref.peek() != null){
               returning = (E) stack.pop();
           }
        } catch (StackException e) {
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
