package ImmutableRankingList;

import ImmutableDoubleLinkedList.ImmutablePlacement;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 25/12/2013
 * Time: 13:27
 */
public class ImmutablePlacementAwareRank<K, V> extends ImmutableRank<K, V> implements IImmutableRank<K, V> {

    private ImmutablePlacement<ImmutableRank<K, V>> location;

    public ImmutablePlacementAwareRank(K key, V val) {
        super(key, val);
    }

    public ImmutablePlacementAwareRank(K key, V val, ImmutablePlacement<ImmutableRank<K, V>> placement){
        super(key, val);
        location = placement;
    }

    protected ImmutablePlacement<ImmutableRank<K, V>> location(){
        return location;
    }

//    protected ImmutablePlacement<ImmutableRank<K, V>> setLocation(ImmutablePlacement<ImmutableRank<K, V>> placement){
//        ImmutablePlacement<ImmutableRank<K, V>> oldPos = location();
//        location = placement;
//        return oldPos;
//    }
//
//    protected K setKey(K key){
//        K oldKey = getKey();
//        k = key;
//        return oldKey;
//    }
//
//    protected V setVal(V val){
//        V oldVal = getVal();
//        v = val;
//        return oldVal;
//    }
}
