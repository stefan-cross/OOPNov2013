package ImmutableRankingList;

import ImmutableDoubleLinkedList.EmptyListException;
import ImmutableDoubleLinkedList.InvalidPlaceException;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 25/12/2013
 * Time: 13:49
 */
public interface IImmutableSortedAdaptableRankingList<K, V> {

    public ImmutableRank<K, V> remove(ImmutableRank<K, V> rank) throws InvalidPlaceException;

    public K replaceKey(ImmutableRank<K, V> rank, K key) throws EmptyListException, InvalidPlaceException;

    public V replaceVal(ImmutableRank<K, V> rank, V val) throws InvalidPlaceException;
}
