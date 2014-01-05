package DLRankList;

import DLList.DNode;
import DLList.EmptyListException;
import DLList.InvalidPlaceException;

import javax.management.openmbean.InvalidKeyException;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 25/12/2013
 * Time: 13:45
 */
public class SortedAdaptableRankList<K, V> extends SortedRankList<K, V> implements ISortedAdaptableRankList<K, V> {


    public SortedAdaptableRankList(){
        super();
    }

    public SortedAdaptableRankList(RankComparator<K> comp){
        super(comp);
    }

    public Rank<K, V> insert(K key, V val) throws EmptyListException, InvalidPlaceException {
        checkKey(key);
        RankDNode<K, V> rank = new RankDNode<K, V>(key, val);
        insertRank(rank);
        rank.setLocation((DNode<Rank<K,V>>) placement);
        return rank;
    }


    public Rank<K, V> remove(Rank<K, V> rank) throws InvalidPlaceException {
        checkRank(rank);
        RankDNode<K, V> r = (RankDNode<K, V>) rank;
        DNode<Rank<K, V>> p = r.location();
        rankings.removeElement(p);
        r.setLocation(null);
        return r;
    }

    public K replaceKey(Rank<K, V> rank, K key) throws EmptyListException, InvalidPlaceException {
        checkKey(key);
        checkRank(rank);
        RankDNode<K, V> r = (RankDNode<K, V>) remove(rank);
        K oldKey = r.setKey(key);
        insertRank(r);
        r.setLocation((DNode<Rank<K,V>>) placement);
        return oldKey;
    }

    public V replaceVal(Rank<K, V> rank, V val) throws InvalidPlaceException {
        checkRank(rank);
        V oldValue = ((RankDNode<K, V>) rank).setVal(val);
        return oldValue;
    }


    protected void checkRank(Rank r) throws InvalidPlaceException{
        if((r == null) || !(r instanceof RankDNode)){
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
