package RankingList;

import DoubleLinkedList.*;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 16/12/2013
 * Time: 20:37
 */

public class SortedRankingList<K, V> implements IRankingList<K, V> {

    protected List<IRank<K, V>> rankings;
    protected IPlacement<IRank<K, V>> placement;
    protected RankingComparator<K> comparator;
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
        comparator = new RankingComparator<K>();
        numEls = 0;
    }

    // Overloaded constructor
    public SortedRankingList(RankingComparator<K> c) {
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
        // As theres nothing in the list add our element to the end
        if(rankings.isEmpty()){
            rankings.addLast(r);
            placement = rankings.last();
        }
        // if the var key val is less then the last ranking elements key val then add it
        else if (comparator.compare(r.getKey(), rankings.last().element().getKey()) < 0){
            rankings.addLast(r);
            placement = rankings.last();
        }
        else {
            // iterate through our ranking list using comparator to decide placement
            IPlacement<IRank<K, V>> current = rankings.first();
            //
            while(comparator.compare(r.getKey(), current.element().getKey()) < 0){
                current = rankings.prev(current);

            }
            rankings.insertNext(current, r);
            placement = rankings.next(current);
        }
    }

    //TODO iterate over keyvalue pairs and write toString Method

    public Iterator<K> iterator(){
        return new ElementIterator<K>((List<K>) rankings);
    }

    public <K> String toString(SortedRankingList<K, V> r) {
        Iterator<K> i = r.iterator();
        String s = "";
        //TODO make constructor for Rank so it rather then using null as its dangerous and its not handled well
        Rank<K, V> j = null;

        while(i.hasNext()){

            j =  (Rank)i.next();
            s += " Plays - " + String.format("%s | Track - %s", j.k.toString(), j.v.toString());
            if(i.hasNext()){
                s += "\n";
            }
        }
        s += "";
        return s;
    }

    public String toString(K e){
        String s = e.toString();
        return s;
    }

}
