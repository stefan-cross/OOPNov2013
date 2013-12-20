package RankingList;

import DoubleLinkedList.EmptyListException;
import DoubleLinkedList.IPlacement;
import DoubleLinkedList.InvalidPlaceException;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 20/12/2013
 * Time: 13:02
 */
public class KeyValueIterator<K, V> implements Iterator<K> {

    protected SortedRankingList<K, V> sortedRankingList;
    protected IPlacement<K> pointer;

    public KeyValueIterator(SortedRankingList<K, V> l) throws EmptyListException, InvalidPlaceException {
        sortedRankingList = l;
        if(sortedRankingList.isEmpty()){
            pointer = null;
        } else {
            pointer = (IPlacement<K>) sortedRankingList.max();
        }
    }

    @Override
    public boolean hasNext() {
        return (pointer != null);
    }

    @Override
    public K next() {
        K returning = null;
        if(pointer == null){
            throw new NoSuchElementException();
        } else {
            try {
                returning = pointer.element();

            } catch (InvalidPlaceException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void remove() {

    }
}
