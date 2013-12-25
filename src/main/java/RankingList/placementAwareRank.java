package RankingList;

import DoubleLinkedList.Placement;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 25/12/2013
 * Time: 13:27
 */
public class PlacementAwareRank<K, V> extends Rank<K, V> implements IRank<K, V>{

    private Placement<Rank<K, V>> location;

    public PlacementAwareRank(K key, V val) {
        super(key, val);
    }

    public PlacementAwareRank(K key, V val, Placement<Rank<K, V>> placement){
        super(key, val);
        location = placement;
    }

    protected Placement<Rank<K, V>> location(){
        return location;
    }

    protected Placement<Rank<K, V>> setLocation(Placement<Rank<K, V>> placement){
        Placement<Rank<K, V>> oldPos = location();
        location = placement;
        return oldPos;
    }

    protected K setKey(K key){
        K oldKey = getKey();
        k = key;
        return oldKey;
    }

    protected V setVal(V val){
        V oldVal = getVal();
        v = val;
        return oldVal;
    }
}
