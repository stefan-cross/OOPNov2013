package RankingList;

import DoubleLinkedList.*;
import Library.IDownloads;
import Library.IPlays;

import java.util.Iterator;

/**
 * User: stefancross
 * Date: 16/12/2013
 * Time: 20:37
 */

public class SortedRankingList<K, V> implements IRankingList<K, V> {
    //
    protected PlacementList<IRank<K, V>> rankings;
    protected IPlacement<IRank<K, V>> placement;
    protected RankingComparator<K> comparator;
    private int numEls;

    // Standard constructor, note comparison on key
    public SortedRankingList(){
        rankings = new PlacementList<IRank<K, V>>();
        comparator = new RankingComparator<K>();
        numEls = 0;
    }
//
//    // Overloaded constructor
//    public SortedRankingList(RankingComparator<K> c) {
//        comparator = c;
//        rankings = new PlacementList<IRank<K, V>>();
//        numEls = 0;
//    }

    public int size() {
        return numEls;
    }

    public boolean isEmpty() {
        return (numEls == 0);
    }

    public IRank<K, V> max() throws EmptyListException, InvalidPlaceException {
       if(rankings.isEmpty()){
           throw new EmptyListException("RankingList is empty");
       } else {
           return rankings.last().element();
       }
    }
    
    public IRank<K, V> insert(K key, V val) throws EmptyListException, InvalidPlaceException {
        IRank<K, V> rank = new Rank<K, V>(key, val);
        insertRank(rank);
        numEls++;
        return rank;
    }

    // for internal use only, insert functionality is exposed via previous public insert method
    // which in turn utilised this to verify valid insertion
    private void insertRank(IRank<K, V> r) throws EmptyListException, InvalidPlaceException {
        // As theres nothing in the placementList add our element to the end
        if(rankings.isEmpty()){
            rankings.addFirst(r);
            placement = rankings.first();
        }
        // if the var key val is less then the last ranking elements key val then add it
        else if (comparator.compare(r.getKey(), rankings.last().element().getKey()) < 0){
            rankings.addLast(r);
            placement = rankings.last();
        }
        else {
            // iterate through our ranking placementList using comparator to decide placement
            IPlacement<IRank<K, V>> current = rankings.first();
            //compare our new key with first key of current ranking
            //if its greater then then current we get 1 if its less the the current element we get -1
            while(comparator.compare(r.getKey(), current.element().getKey()) < 0){
                // if its less then the current el then we walk back through the placementList
                current = rankings.prev(current);
            }
            // otherwise our new el is to go to in front of current
            rankings.insertNext(current, r);
            // placed
            placement = rankings.next(current);
        }
    }

    public Iterator<K> iterator(){
        // Cast our ranking list to a placement list and iterate through
        return new ElementIterator<K>((PlacementList<K>) rankings);
    }

    public <K> String toString(SortedRankingList<K, V> r, Class<?> cls) {
        Iterator<K> i = r.iterator();
        String s = "";
        String label = "";
        Rank<K, V> j = null;
        // class type used to format string
        if(cls == IPlays.class){ label = "Plays ";}
        else if(cls == IDownloads.class){ label = "Downloads";}

        while(i.hasNext()){
            j =  (Rank)i.next();
            // move through list and create string and apply label
            s += label + " - " + String.format("%s | Artist/Track - %s", j.k.toString(), j.v.toString());
            if(i.hasNext()){
                s += "\n";
            }
        }
        s += "";
        return s;
    }

}
