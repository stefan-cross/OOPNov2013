package RankingList;

import DoubleLinkedList.EmptyListException;
import DoubleLinkedList.InvalidPlaceException;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 16/12/2013
 * Time: 20:01
 */
// Where K is Key and V is Value
public interface IRankingList<K, V> {

    public int size();

    public boolean isEmpty();

    public IRank<K, V> max() throws EmptyListException, InvalidPlaceException;

    public IRank<K, V> removeMax() throws EmptyListException, InvalidPlaceException;

    public IRank<K, V> insert(K key, V val) throws EmptyListException, InvalidPlaceException;
}
