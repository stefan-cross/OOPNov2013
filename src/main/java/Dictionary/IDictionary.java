package Dictionary;

import RankingList.Rank;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 30/12/2013
 * Time: 20:45
 */
public interface IDictionary<K, V> {

    public int size();

    public boolean isEmpty();

    public Map.Entry<K, V> get(K k);

    public Iterable<Map.Entry<K,V>> getAll(K k);

    public Map.Entry<K, V> put(K k, V v);

    public Map.Entry<K,V> remove(Map.Entry<K,V> e) throws IllegalArgumentException;

    public Iterable<Map.Entry<K,V> > setEntry();

}
