package ImmutableDoubleLinkedList;

import java.util.Iterator;

/**
 * User: stefancross
 * Date: 13/12/2013
 * Time: 16:55
 */
public class ImmutablePlacementList<E> implements IImmutablePlacementList<E> {

    private int numEls;
    protected ImmutablePlacement<E> front, end;

    // Constructor
    public ImmutablePlacementList(){
        numEls = 0;
        // Initialise a list with a front and an end
        front = new ImmutablePlacement<E>(null, null, null);
        end = new ImmutablePlacement<E>(null, front, null);
        //front.setPrev(end);
        front = new ImmutablePlacement<E>(end, null, null);
    }
    // Validate Position of a Placement
    protected ImmutablePlacement<E> valPosition(ImmutablePlacement<E> r) throws InvalidPlaceException {
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
            ImmutablePlacement<E> test = (ImmutablePlacement<E>) r;
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
    public ImmutablePlacement<E> first() throws EmptyListException {
        if(isEmpty()){
            throw new EmptyListException("There is no first rank as the list is empty");
        }
        return front.getPrev();
    }

    // returns last el after the end position
    public ImmutablePlacement<E> last() throws EmptyListException{
        if(isEmpty()){
            throw new EmptyListException("There is no last rank as the list is empty");
        }
        return end.getNext();
    }

    // returns next el from a given placement
    public ImmutablePlacement<E> next(ImmutablePlacement<E> rank) throws EmptyListException, InvalidPlaceException {
        ImmutablePlacement<E> n = valPosition(rank);
        ImmutablePlacement<E> next = n.getNext();
        if(next == front){
            throw new InvalidPlaceException("Next item is the front of the list, can not proceed");
        }
        return next;
    }

    // returns prev el from a given placement
    public ImmutablePlacement<E> prev(ImmutablePlacement<E> rank) throws InvalidPlaceException {
        ImmutablePlacement<E> n = valPosition(rank);
        ImmutablePlacement<E> prev = n.getPrev();
        if(prev == end){
            throw new InvalidPlaceException("Prev item is the end of the list, can not proceed");
        }
        return prev;
    }

    // Add in a new first element referencing the front el and inserting the given element
    public void addFirst(E element) throws InvalidPlaceException {
        ImmutablePlacement<E> newFirst = new ImmutablePlacement<E>(front.getPrev(), front, element);
        //front.getPrev().setNext(newNode);
        ImmutablePlacement oldFirst =  new ImmutablePlacement(newFirst.getPrev(), newFirst, newFirst.getPrev().element());
        //front.setPrev(newNode);
        front = new ImmutablePlacement<E>(newFirst, null, null);
        numEls++;
    }

    // Add in a new last element referencing the last el and inserting the given element
    public void addLast(E element) throws InvalidPlaceException {
        ImmutablePlacement<E> newLast = new ImmutablePlacement<E>(end, end.getNext(), element);
        //end.getNext().setPrev(newNode);
        ImmutablePlacement<E> oldLast = new ImmutablePlacement<E>(newLast, newLast.getNext(), newLast.getNext().element());
        //end.setNext(newNode);
        end = new ImmutablePlacement<E>(null, end.getNext(), null);
        numEls++;
    }
    //TODO insert prev and next maybe confused..
    // Insert a given element behind a given place
    public void insertPrev(ImmutablePlacement<E> p, E el) throws InvalidPlaceException {
        // Validate the placement position
        ImmutablePlacement<E> v = valPosition(p);
        ImmutablePlacement<E> newNode = new ImmutablePlacement<E>(v.getPrev(), v, el);
        //v.getPrev().setNext(newNode);
        ImmutablePlacement<E> oldNode = new ImmutablePlacement<E>(newNode.getNext(), newNode, newNode.getNext().element());
        //v.setPrev(newNode);
        ImmutablePlacement<E> oldV = new ImmutablePlacement<E>(newNode, v.getNext(), v.element());

        numEls++;
    }
    //TODO unit check functionality
    // Insert a given element in front a given place
    public void insertNext(ImmutablePlacement<E> p, E el) throws InvalidPlaceException {
        // Validate the placement position
        ImmutablePlacement<E> v = valPosition(p);
        ImmutablePlacement<E> newNode = new ImmutablePlacement<E>(v, v.getNext(), el);
        //v.getNext().setPrev(newNode);
        ImmutablePlacement<E> oldNext = new ImmutablePlacement<E>(newNode, newNode.getNext(), newNode.getNext().element());
        //v.setNext(newNode);
        ImmutablePlacement<E> oldPrev = new ImmutablePlacement<E>(v.getPrev(), newNode, v.element());
        numEls++;
    }

    public E removeElement(ImmutablePlacement<E> e) throws InvalidPlaceException {
        // Check out Rank is of a valid place in the list
        ImmutablePlacement<E> n = valPosition(e);
        numEls--;
        // Identify the nodes either side of current position
        ImmutablePlacement<E> nPrev = n.getPrev();
        ImmutablePlacement<E> nNext = n.getNext();
        // Link references back to connect list
        //nPrev.setNext(nNext); nNext.setPrev(nPrev);
        ImmutablePlacement<E> newPrev = new ImmutablePlacement<E>(nNext, nPrev.getPrev(), nPrev.element());
        ImmutablePlacement<E> newNext = new ImmutablePlacement<E>(nNext.getNext(), nPrev, nNext.element());
        // Set ranking element to
        E IPlacementEl = n.element();
        //dispose of the current rank from the list and the old nPrev and nNext
        n = null; nPrev = null; nNext = null;
        return IPlacementEl;
    }

    public Iterator<E> iterator(){
        // Instantiate ElementIterator with instance of PlacementList (this)
        return new ElementIterator<E>(this);
    }

    // toString to utilise iterator to override standard toString
    public static <E> String toString(ImmutablePlacementList<E> r) {
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
