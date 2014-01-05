package DLList;

public interface IRankList<K, V> {
    // Returns size of ranked list
    public int size();
    // Returns true or false if ranked list contains elements
    public boolean isEmpty();
    // returns the max value in a sorted list
    public IRank<K, V> max() throws EmptyListException, InvalidPlaceException;
    // inserts a key and value returning a rank
    public IRank<K, V> insert(K key, V val) throws EmptyListException, InvalidPlaceException;
    // removes a rank
    public Rank<K, V> remove(Rank<K, V> rank) throws InvalidPlaceException;
    // replaces a key on a given rank
    public K replaceKey(Rank<K, V> rank, K key) throws EmptyListException, InvalidPlaceException;
    // replaces a val on a given rank
    public V replaceVal(Rank<K, V> rank, V val) throws InvalidPlaceException;
}
