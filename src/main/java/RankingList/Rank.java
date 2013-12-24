package RankingList;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 23/12/2013
 * Time: 23:24
 */

class Rank<K, V> implements IRank<K, V> {
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
}
