package ImmutableRankingList;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 23/12/2013
 * Time: 23:24
 */

public class ImmutableRank<K, V> implements IImmutableRank<K, V> {
    // where K and V are Key and Value
    protected K k;
    protected V v;

    public ImmutableRank(K key, V val){
        k = key;
        v = val;
    }

    public K getKey() {
        return k;
    }

    public V getVal() {
        return v;
    }

    public String toString() {
        return "Count: " + k.toString() + " | Artist/Track " + v.toString();
    }
}
