package DLRankList;

import DLList.Node;
import DLList.EmptyListException;
import DLList.InvalidPlaceException;

import javax.management.openmbean.InvalidKeyException;

public class SortedAdaptableRankList<K, V> extends SortedRankList<K, V> implements ISortedAdaptableRankList<K, V> {


    public SortedAdaptableRankList(){
        super();
    }

    public SortedAdaptableRankList(RankComparator<K> comp){
        super(comp);
    }

    public Rank<K, V> insert(K key, V val) throws EmptyListException, InvalidPlaceException {
        validateKey(key);
        RankNode<K, V> rank = new RankNode<K, V>(key, val);
        insertRank(rank);
        rank.setLocation((Node<Rank<K,V>>) placement);
        return rank;
    }


    public Rank<K, V> remove(Rank<K, V> rank) throws InvalidPlaceException {
        validateRank(rank);
        RankNode<K, V> r = (RankNode<K, V>) rank;
        Node<Rank<K, V>> p = r.location();
        rankings.removeElement(p);
        r.setLocation(null);
        return r;
    }

    public K replaceKey(Rank<K, V> rank, K key) throws EmptyListException, InvalidPlaceException {
        validateKey(key);
        validateRank(rank);
        RankNode<K, V> r = (RankNode<K, V>) remove(rank);
        K oldKey = r.setKey(key);
        insertRank(r);
        r.setLocation((Node<Rank<K,V>>) placement);
        return oldKey;
    }

    public V replaceVal(Rank<K, V> rank, V val) throws InvalidPlaceException {
        validateRank(rank);
        V oldValue = ((RankNode<K, V>) rank).setVal(val);
        return oldValue;
    }


    protected void validateRank(Rank r) throws InvalidPlaceException{
        if((r == null) || !(r instanceof RankNode)){
            throw new InvalidPlaceException("Not a valid placement");
        }
    }

    protected void validateKey(K key) throws InvalidKeyException {
        try{
            comparator.compare(key, key);
        } catch (Exception e){
            throw new InvalidKeyException("Invalid Key");
        }
    }

}
