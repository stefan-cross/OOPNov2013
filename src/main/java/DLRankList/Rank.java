package DLRankList;

public class Rank<K, V> implements IRank<K, V> {
    // where K and V are Key and Value
    protected K k;
    protected V v;

    public Rank(K key, V val){
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
