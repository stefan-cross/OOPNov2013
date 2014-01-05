package DLRankList;

import DLList.EmptyListException;
import DLList.InvalidPlaceException;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 25/12/2013
 * Time: 13:49
 */
public interface ISortedAdaptableRankList<K, V> {

    public Rank<K, V> remove(Rank<K, V> rank) throws InvalidPlaceException;

    public K replaceKey(Rank<K, V> rank, K key) throws EmptyListException, InvalidPlaceException;

    public V replaceVal(Rank<K, V> rank, V val) throws InvalidPlaceException;
}
