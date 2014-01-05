package DLList;

import java.util.Iterator;

/**
 * User: stefancross
 * Date: 13/12/2013
 * Time: 16:55
 */
public class List<E> implements IList<E> {

    private int numEls;
    protected DNode<E> front, end;

    // Constructor
    public List(){
        numEls = 0;
        // Initialise a list with a front and an end
        front = new DNode<E>(null, null, null);
        end = new DNode<E>(null, front, null);
        front.setPrev(end);
    }
    // Validate Position of a Placement
    protected DNode<E> valPosition(IDNode<E> r) throws InvalidPlaceException {
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
            DNode<E> test = (DNode<E>) r;
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
    public IDNode<E> first() throws EmptyListException {
        if(isEmpty()){
            throw new EmptyListException("There is no first rank as the list is empty");
        }
        return front.getPrev();
    }

    // returns last el after the end position
    public IDNode<E> last() throws EmptyListException{
        if(isEmpty()){
            throw new EmptyListException("There is no last rank as the list is empty");
        }
        return end.getNext();
    }

    // returns next el from a given placement
    public IDNode<E> next(IDNode<E> rank) throws EmptyListException, InvalidPlaceException {
        DNode<E> n = valPosition(rank);
        DNode<E> next = n.getNext();
        if(next == front){
            throw new InvalidPlaceException("Next item is the front of the list, can not proceed");
        }
        return next;
    }

    // returns prev el from a given placement
    public IDNode<E> prev(IDNode<E> rank) throws InvalidPlaceException {
        DNode<E> n = valPosition(rank);
        DNode<E> prev = n.getPrev();
        if(prev == end){
            throw new InvalidPlaceException("Prev item is the end of the list, can not proceed");
        }
        return prev;
    }

    // Add in a new first element referencing the front el and inserting the given element
    public void addFirst(E element){
        DNode<E> newNode = new DNode<E>(front.getPrev(), front, element);
        front.getPrev().setNext(newNode);
        front.setPrev(newNode);
        numEls++;
    }

    // Add in a new last element referencing the last el and inserting the given element
    public void addLast(E element) throws InvalidPlaceException {
        DNode<E> newNode = new DNode<E>(end, end.getNext(), element);
        end.getNext().setPrev(newNode);
        end.setNext(newNode);
        numEls++;
    }

    // Insert a given element behind a given place
    public void insertPrev(IDNode<E> p, E el) throws InvalidPlaceException {
        // Validate the placement position
        DNode<E> v = valPosition(p);
        DNode<E> newNode = new DNode<E>(v.getPrev(), v, el);
        v.getPrev().setNext(newNode);
        v.setPrev(newNode);
        numEls++;
    }

    // Insert a given element in front a given place
    public void insertNext(IDNode<E> p, E el) throws InvalidPlaceException {
        // Validate the placement position
        DNode<E> v = valPosition(p);
        DNode<E> newNode = new DNode<E>(v, v.getNext(), el);
        v.getNext().setPrev(newNode);
        v.setNext(newNode);
        numEls++;
    }

    public E removeElement(IDNode<E> e) throws InvalidPlaceException {
        // Check out Rank is of a valid place in the list
        DNode<E> n = valPosition(e);
        numEls--;
        // Identify the nodes either side of current position
        DNode<E> nPrev = n.getPrev();
        DNode<E> nNext = n.getNext();
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
        return new NodeIterator<E>(this);
    }

    // toString to utilise iterator to override standard toString
    public static <E> String toString(List<E> r) {
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
