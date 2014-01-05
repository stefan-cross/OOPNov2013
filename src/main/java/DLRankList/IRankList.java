package DLRankList;

import DLList.EmptyListException;
import DLList.InvalidPlaceException;

// Where K is Key and V is Value
public interface IRankList<K, V> {
    // Returns size of ranked list
    public int size();
    // Returns true or false if ranked list contains elements
    public boolean isEmpty();
    // returns the max value in a sorted list
    public IRank<K, V> max() throws EmptyListException, InvalidPlaceException;
    // inserts a key and value returning a rank
    public IRank<K, V> insert(K key, V val) throws EmptyListException, InvalidPlaceException;
}
