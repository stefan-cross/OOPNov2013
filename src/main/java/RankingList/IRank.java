package RankingList;

/**
 * User: stefancross
 * Date: 16/12/2013
 * Time: 20:05
 */
public interface IRank<K, V> {
    // gets key of generic type
    public K getKey();
    // gets value of generic type
    public V getVal();

}
