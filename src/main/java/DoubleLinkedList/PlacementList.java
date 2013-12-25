package DoubleLinkedList;

import RankingList.Rank;

import java.util.Iterator;

/**
 * User: stefancross
 * Date: 13/12/2013
 * Time: 16:55
 */
public class PlacementList<E> implements IPlacementList<E> {

    private int numEls;
    protected Placement<E> front, end;

    // Constructor
    public PlacementList(){
        numEls = 0;
        // Initialise a list with a front and an end
        front = new Placement<E>(null, null, null);
        end = new Placement<E>(null, front, null);
        front.setPrev(end);
    }
    // Validate Position of a Placement
    protected Placement<E> valPosition(IPlacement<E> r) throws InvalidPlaceException {
        // We cant place nulls into the list
        if(r == null){
            throw new InvalidPlaceException("A null value was given to the list");
        }
        // Front and End positions are special and reserved
        if((r == front) || (r == end)){
            throw new InvalidPlaceException("Front or End places are not valid ranks");
        }
        try{
            // Cast our rank to a node if its not fallen foul of the previous potential issues
            Placement<E> test = (Placement<E>) r;
            // Test to see if the placement has valid and has next and prev placements
            if((test.getNext() == null) || (test.getPrev() == null)){
                throw new InvalidPlaceException("Rank doesn't exist in the current list");
            }
            return test;
        } catch (ClassCastException e){
            throw new InvalidPlaceException("Rank is of incompatible type for this ranking list");
        }
    }

    public int size() {
        return numEls;
    }

    public Boolean isEmpty() {
        return(numEls == 0);
    }

    // returns first el after the leading front position
    public IPlacement<E> first() throws EmptyListException {
        if(isEmpty()){
            throw new EmptyListException("There is no first rank as the list is empty");
        }
        return front.getPrev();
    }

    // returns last el after the end position
    public IPlacement<E> last() throws EmptyListException{
        if(isEmpty()){
            throw new EmptyListException("There is no last rank as the list is empty");
        }
        return end.getNext();
    }

    // returns next el from a given placement
    public IPlacement<E> next(IPlacement<E> rank) throws EmptyListException, InvalidPlaceException {
        Placement<E> n = valPosition(rank);
        Placement<E> next = n.getNext();
        if(next == front){
            throw new InvalidPlaceException("Next item is the front of the list, can not proceed");
        }
        return next;
    }

    // returns prev el from a given placement
    public IPlacement<E> prev(IPlacement<E> rank) throws InvalidPlaceException {
        Placement<E> n = valPosition(rank);
        Placement<E> prev = n.getPrev();
        if(prev == end){
            throw new InvalidPlaceException("Prev item is the end of the list, can not proceed");
        }
        return prev;
    }

    // Add in a new first element referencing the front el and inserting the given element
    public void addFirst(E element){
        Placement<E> newNode = new Placement<E>(front.getPrev(), front, element);
        front.getPrev().setNext(newNode);
        front.setPrev(newNode);
        numEls++;
    }

    // Add in a new last element referencing the last el and inserting the given element
    public void addLast(E element) throws InvalidPlaceException {
        Placement<E> newNode = new Placement<E>(end, end.getNext(), element);
        end.getNext().setPrev(newNode);
        end.setNext(newNode);
        numEls++;
    }

    // Insert a given element behind a given place
    public void insertPrev(IPlacement<E> p, E el) throws InvalidPlaceException {
        // Validate the placement position
        Placement<E> v = valPosition(p);
        Placement<E> newNode = new Placement<E>(v.getPrev(), v, el);
        v.getPrev().setNext(newNode);
        v.setPrev(newNode);
        numEls++;
    }

    // Insert a given element in front a given place
    public void insertNext(IPlacement<E> p, E el) throws InvalidPlaceException {
        // Validate the placement position
        Placement<E> v = valPosition(p);
        Placement<E> newNode = new Placement<E>(v, v.getNext(), el);
        v.getNext().setPrev(newNode);
        v.setNext(newNode);
        numEls++;
    }

    public E removeElement(IPlacement<E> e) throws InvalidPlaceException {
        // Check out Rank is of a valid place in the list
        Placement<E> n = valPosition(e);
        numEls--;
        // Identify the nodes either side of current position
        Placement<E> nPrev = n.getPrev();
        Placement<E> nNext = n.getNext();
        // Link references back to connect list
        nPrev.setNext(nNext);
        nNext.setPrev(nPrev);
        // Set ranking element to
        E IPlacementEl = n.element();
        //dispose of the current rank from the list
        n.setNext(null);
        n.setPrev(null);
        return IPlacementEl;
    }

    public Iterator<E> iterator(){
        // Instantiate ElementIterator with instance of PlacementList (this)
        return new ElementIterator<E>(this);
    }

    // toString to utilise iterator to override standard toString
    public static <E> String toString(PlacementList<E> r) {
        Iterator<E> i = r.iterator();
        String s = "";
        // use iterator method to step through elements
        while(i.hasNext()){
            s += i.next();
            if(i.hasNext()){
                s += "\n";
            }
        }
        s += "";
        return s;
    }

}
