package RankingList;

import DoubleLinkedList.EmptyListException;
import DoubleLinkedList.InvalidPlaceException;
import DoubleLinkedList.Placement;

import javax.management.openmbean.InvalidKeyException;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 25/12/2013
 * Time: 13:45
 */
public class SortedAdaptableRankingList<K, V> extends SortedRankingList<K, V> implements ISortedAdaptableRankingList<K, V>{


    public SortedAdaptableRankingList(){
        super();
    }

    public SortedAdaptableRankingList(RankingComparator<K> comp){
        super(comp);
    }

    public Rank<K, V> insert(K key, V val) throws EmptyListException, InvalidPlaceException {
        checkKey(key);
        PlacementAwareRank<K, V> rank = new PlacementAwareRank<K, V>(key, val);
        insertRank(rank);
        rank.setLocation((Placement<Rank<K,V>>) placement);
        return rank;
    }


    public Rank<K, V> remove(Rank<K, V> rank) throws InvalidPlaceException {
        checkRank(rank);
        PlacementAwareRank<K, V> r = (PlacementAwareRank<K, V>) rank;
        Placement<Rank<K, V>> p = r.location();
        rankings.removeElement(p);
        r.setLocation(null);
        return r;
    }

    public K replaceKey(Rank<K, V> rank, K key) throws EmptyListException, InvalidPlaceException {
        checkKey(key);
        checkRank(rank);
        PlacementAwareRank<K, V> r = (PlacementAwareRank<K, V>) remove(rank);
        K oldKey = r.setKey(key);
        insertRank(r);
        r.setLocation((Placement<Rank<K,V>>) placement);
        return oldKey;
    }

    public V replaceVal(Rank<K, V> rank, V val) throws InvalidPlaceException {
        checkRank(rank);
        V oldValue = ((PlacementAwareRank<K, V>) rank).setVal(val);
        return oldValue;
    }


    protected void checkRank(Rank r) throws InvalidPlaceException{
        if((r == null) || !(r instanceof PlacementAwareRank)){
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
