package RankingList;

import DoubleLinkedList.EmptyListException;
import DoubleLinkedList.InvalidPlaceException;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 25/12/2013
 * Time: 13:49
 */
public interface ISortedAdaptableRankingList<K, V> {

    public Rank<K, V> remove(Rank<K, V> rank) throws InvalidPlaceException;

    public K replaceKey(Rank<K, V> rank, K key) throws EmptyListException, InvalidPlaceException;

    public V replaceVal(Rank<K, V> rank, V val) throws InvalidPlaceException;
}
