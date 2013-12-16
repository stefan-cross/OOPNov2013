package RankingList;

import DoubleLinkedList.EmptyListException;
import DoubleLinkedList.IPlacement;
import DoubleLinkedList.InvalidPlaceException;
import DoubleLinkedList.List;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 16/12/2013
 * Time: 20:37
 */

public class SortedRankingList<K, V> implements IRankingList<K, V> {

    protected List<IRank<K, V>> rankings;
    protected IPlacement<IRank<K, V>> placement;
    protected RankingComparator<V> comparator;
    private int numEls;


    // Inner class to be utilised by rankings var
    protected static class Rank<K, V> implements IRank<K, V> {

        protected K k;
        protected V v;

        public Rank(K key, V val){
            k = key;
            v = val;
        }

        @Override
        public K getKey() {
            return k;
        }
        @Override
        public V getVal() {
            return v;
        }
    }

    // Standard constructor, note comparison on value rather then key
    public SortedRankingList(){
        rankings = new List<IRank<K, V>>();
        comparator = new RankingComparator<V>();
        numEls = 0;
    }

    // Overloaded constructor
    public SortedRankingList(RankingComparator<V> c) {
        comparator = c;
        rankings = new List<IRank<K, V>>();
        numEls = 0;
    }


    @Override
    public int size() {
        return numEls;
    }

    @Override
    public boolean isEmpty() {
        return (numEls == 0);
    }

    //TODO RankingList Package needs own exceptions to better help locate errors as and when they happen at run time
    @Override
    public IRank<K, V> max() throws EmptyListException, InvalidPlaceException {
       if(rankings.isEmpty()){
           throw new EmptyListException("RankingList is empty");
       } else {
           return rankings.last().element();
       }
    }

    @Override
    public IRank<K, V> removeMax() throws EmptyListException, InvalidPlaceException {
        if(rankings.isEmpty()){
            throw new EmptyListException("RankingList is empty");
        } else {
            return rankings.removeElement(rankings.last());
        }
    }

    @Override
    public IRank<K, V> insert(K key, V val) throws EmptyListException, InvalidPlaceException {
        IRank<K, V> rank = new Rank<K, V>(key, val);
        insertRank(rank);
        numEls++;
        return rank;
    }


    // for internal use only
    protected void insertRank(IRank<K, V> r) throws EmptyListException, InvalidPlaceException {

        if(rankings.isEmpty()){
            rankings.addFirst(r);
            placement = rankings.first();
        }
        else if (comparator.compare(r.getVal(), rankings.last().element().getVal()) > 0){
            rankings.addLast(r);
            placement = rankings.last();
        }
        else {
            IPlacement<IRank<K, V>> current = rankings.first();
            // iterate through our ranking list using comparator to decide placement
            while(comparator.compare(r.getVal(), current.element().getVal()) > 0){
                current = rankings.next(current);

            }
            rankings.insertPrev(current, r);

            //TODO some confusion about type here...
            //placement = rankings.prev(current);
        }
    }

    //TODO iterate over keyvalue pairs and write toString Method
}
