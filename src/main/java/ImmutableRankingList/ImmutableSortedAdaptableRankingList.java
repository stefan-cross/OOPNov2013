package ImmutableRankingList;

import ImmutableDoubleLinkedList.EmptyListException;
import ImmutableDoubleLinkedList.InvalidPlaceException;
import ImmutableDoubleLinkedList.ImmutablePlacement;

import javax.management.openmbean.InvalidKeyException;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 25/12/2013
 * Time: 13:45
 */
public class ImmutableSortedAdaptableRankingList<K, V> extends SortedImmutableRankingList<K, V> implements IImmutableSortedAdaptableRankingList<K, V> {


    public ImmutableSortedAdaptableRankingList(){
        super();
    }

    public ImmutableSortedAdaptableRankingList(RankingComparator<K> comp){
        super(comp);
    }

    public ImmutableRank<K, V> insert(K key, V val) throws EmptyListException, InvalidPlaceException, ImmutableDoubleLinkedList.EmptyListException, ImmutableDoubleLinkedList.InvalidPlaceException {
        checkKey(key);
        ImmutablePlacementAwareRank<K, V> rank = new ImmutablePlacementAwareRank<K, V>(key, val);
        insertRank(rank);
        rank.setLocation((ImmutablePlacement<ImmutableRank<K,V>>) placement);
        return rank;
    }


    public ImmutableRank<K, V> remove(ImmutableRank<K, V> rank) throws InvalidPlaceException {
        checkRank(rank);
        ImmutablePlacementAwareRank<K, V> r = (ImmutablePlacementAwareRank<K, V>) rank;
        ImmutablePlacement<ImmutableRank<K, V>> p = r.location();
        rankings.removeElement(p);
        r.setLocation(null);
        return r;
    }

    public K replaceKey(ImmutableRank<K, V> rank, K key) throws EmptyListException, InvalidPlaceException {
        checkKey(key);
        checkRank(rank);
        ImmutablePlacementAwareRank<K, V> r = (ImmutablePlacementAwareRank<K, V>) remove(rank);
        //K oldKey = r.setKey(key);
        ImmutablePlacementAwareRank<K, V> oldKey = new ImmutablePlacementAwareRank(r.getVal(), key);
        insertRank(r);
        r.setLocation((ImmutablePlacement<ImmutableRank<K,V>>) placement);
        // return oldKey
        return oldKey.k;
    }

    public V replaceVal(ImmutableRank<K, V> rank, V val) throws InvalidPlaceException {
        checkRank(rank);
        //V oldValue = ((ImmutablePlacementAwareRank<K, V>) rank).setVal(val);
        V oldValue = (V) new ImmutablePlacementAwareRank(rank, val);
        return oldValue;
    }


    protected void checkRank(ImmutableRank r) throws InvalidPlaceException{
        if((r == null) || !(r instanceof ImmutablePlacementAwareRank)){
            throw new InvalidPlaceException("Not a valid placement");
        }
    }

    protected void checkKey(K key) throws InvalidKeyException {
        try{
            comparator.compare(key, key);
        } catch (Exception e){
            throw new InvalidKeyException("Invalid Key");
        }
    }

}
