package DLRankList;

import DLList.DNode;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 25/12/2013
 * Time: 13:27
 */
public class RankDNode<K, V> extends Rank<K, V> implements IRank<K, V>{

    private DNode<Rank<K, V>> location;

    public RankDNode(K key, V val) {
        super(key, val);
    }

    public RankDNode(K key, V val, DNode<Rank<K, V>> placement){
        super(key, val);
        location = placement;
    }

    protected DNode<Rank<K, V>> location(){
        return location;
    }

    protected DNode<Rank<K, V>> setLocation(DNode<Rank<K, V>> placement){
        DNode<Rank<K, V>> oldPos = location();
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
