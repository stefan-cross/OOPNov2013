package Stack;

import java.util.Iterator;

public class StackIterator<E> implements Iterator<E> {

    private E e;

    public StackIterator(E e){
        this.e = e;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public E next() {
        return null;
    }

    @Override
    public void remove() {

    }
}
