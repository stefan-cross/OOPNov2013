package Dictionary;

import java.util.Map;

public interface IDictionary<K, V> {

    public int size();

    public boolean isEmpty();

    public Map.Entry<K, V> get(K k);

    public Iterable<Map.Entry<K,V>> getAll(K k);

    public Map.Entry<K, V> put(K k, V v);

    public Map.Entry<K,V> remove(Map.Entry<K,V> e) throws IllegalArgumentException;

    public Iterable<Map.Entry<K,V> > setEntry();

}
