package Dictionary;

import RankingList.Rank;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 31/12/2013
 * Time: 12:40
 */
//TODO finish implmentation 424
public class Dictionary<K, V> implements IDictionary<K,V> {

    Map<K, LinkedList<Map.Entry<K, V>>> m; // map keys to lists of entries
    int nSize;

    public Dictionary(){
        m = new HashMap<K, LinkedList<Map.Entry<K, V>>>(); //default map
        nSize = 0;
    }

    public int size(){
        return nSize;
    }

    public boolean isEmpty(){
        return (nSize == 0);
    }

    public Map.Entry<K, V> get(K k) throws IllegalArgumentException {
        LinkedList<Map.Entry<K, V>> ll;
        if(k == null) throw new IllegalArgumentException();
        if((ll = m.get(k)) == null) return null;
        return ll.peekFirst();
    }

    public Iterable<Map.Entry<K,V>> getAll(K k) throws IllegalArgumentException {
        LinkedList<Map.Entry<K, V>> ll;
        if(k == null) throw new IllegalArgumentException();
        if((ll = m.get(k)) == null) return null;
        return ll;
    }

    public Map.Entry<K, V> put(K key, V val) throws IllegalArgumentException{
        LinkedList<Map.Entry<K, V>> ll;
        if(key == null){
            throw new IllegalArgumentException();
        }
        if((ll = m.get(key)) == null){
            ll = new LinkedList<Map.Entry<K, V>>();
            m.put(key, ll);
        }
        Map.Entry<K, V> e = new AbstractMap.SimpleEntry<K, V>(key, val);
        return null;
    }

    public Map.Entry<K,V> remove(Map.Entry<K,V> e) throws IllegalArgumentException {
        LinkedList<Map.Entry<K, V>> ll;
        if(e == null) throw new IllegalArgumentException();
        K key = e.getKey();
        ll = m.get(key);
        if(ll == null) throw new IllegalArgumentException();
        if(ll.remove(e)){
            nSize--;
            if(ll.isEmpty()) m.remove(key);
            return e;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Iterable<Map.Entry<K, V>> setEntry() {
        LinkedList<Map.Entry<K,V>> ll = new LinkedList<Map.Entry<K, V>>();
        for(LinkedList<Map.Entry<K,V>> sub : m.values())
            ll.addAll(sub);
        return ll;
    }

}
