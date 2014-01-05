package DLRankList;

import DLList.EmptyListException;
import DLList.InvalidPlaceException;

public interface ISortedAdaptableRankList<K, V> {

    public Rank<K, V> remove(Rank<K, V> rank) throws InvalidPlaceException;

    public K replaceKey(Rank<K, V> rank, K key) throws EmptyListException, InvalidPlaceException;

    public V replaceVal(Rank<K, V> rank, V val) throws InvalidPlaceException;
}
