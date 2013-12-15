package RankingList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 15/12/2013
 * Time: 15:09
 * To change this template use File | Settings | File Templates.
 */
public class ElementIterator<E> implements Iterator<E> {

    protected RankingList<E> list;
    protected IRank<E> pointer;

    public ElementIterator(RankingList<E> l) {
        list = l;
        if(list.isEmpty()){
            pointer = null;
        } else {
            try {
                pointer = list.first();
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
            if(pointer == list.last()){
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
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
