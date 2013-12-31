package ImmutableRankingList;

import ImmutableDoubleLinkedList.EmptyListException;
import ImmutableDoubleLinkedList.InvalidPlaceException;

/**
 * User: stefancross
 * Date: 16/12/2013
 * Time: 20:01
 */
// Where K is Key and V is Value
public interface IImmutableRankingList<K, V> {
    // Returns size of ranked list
    public int size();
    // Returns true or false if ranked list contains elements
    public boolean isEmpty();
    // returns the max value in a sorted list
    public IImmutableRank<K, V> max() throws EmptyListException, InvalidPlaceException, ImmutableDoubleLinkedList.EmptyListException, ImmutableDoubleLinkedList.InvalidPlaceException;
    // inserts a key and value returning a rank
    public IImmutableRank<K, V> insert(K key, V val) throws EmptyListException, InvalidPlaceException, ImmutableDoubleLinkedList.EmptyListException, ImmutableDoubleLinkedList.InvalidPlaceException;
}
