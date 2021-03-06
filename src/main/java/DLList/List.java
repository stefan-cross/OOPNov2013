package DLList;

import java.util.Iterator;

public class List<E> implements IList<E> {

    private int numEls;
    protected Node<E> front, end;

    // Constructor
    public List(){
        numEls = 0;
        // Initialise a list with a front and an end
        front = new Node<E>(null, null, null);
        end = new Node<E>(null, front, null);
        front.setPrev(end);
    }

    public int size() {
        return numEls;
    }

    public Boolean isEmpty() {
        return(numEls == 0);
    }

    // returns first el after the leading front position
    public INode<E> first() throws EmptyListException {
        if(isEmpty()){
            throw new EmptyListException("There is no first rank as the list is empty");
        }
        return front.getPrev();
    }

    // returns last el after the end position
    public INode<E> last() throws EmptyListException{
        if(isEmpty()){
            throw new EmptyListException("There is no last rank as the list is empty");
        }
        return end.getNext();
    }

    // returns next el from a given placement
    public INode<E> next(INode<E> rank) throws EmptyListException, InvalidPlaceException {
        Node<E> n = validatePos(rank);
        Node<E> next = n.getNext();
        if(next == front){
            throw new InvalidPlaceException("Next item is the front of the list, can not proceed");
        }
        return next;
    }

    // returns prev el from a given placement
    public INode<E> prev(INode<E> rank) throws InvalidPlaceException {
        Node<E> n = validatePos(rank);
        Node<E> prev = n.getPrev();
        if(prev == end){
            throw new InvalidPlaceException("Prev item is the end of the list, can not proceed");
        }
        return prev;
    }

    // Add in a new first element referencing the front el and inserting the given element
    public void addFirst(E element){
        Node<E> newNode = new Node<E>(front.getPrev(), front, element); // create new node
        front.getPrev().setNext(newNode); // amend nodes either side
        front.setPrev(newNode);
        numEls++;
    }

    // Add in a new last element referencing the last el and inserting the given element
    public void addLast(E element) throws InvalidPlaceException {
        Node<E> newNode = new Node<E>(end, end.getNext(), element); // create new node
        end.getNext().setPrev(newNode);   // amend nodes either side
        end.setNext(newNode);
        numEls++;
    }

    // Insert a given element behind a given place
    public void insertPrev(INode<E> p, E el) throws InvalidPlaceException {
        // Validate the placement position
        Node<E> v = validatePos(p);
        Node<E> newNode = new Node<E>(v.getPrev(), v, el); // create new node
        v.getPrev().setNext(newNode); // amend nodes either side
        v.setPrev(newNode);
        numEls++;
    }

    // Insert a given element in front a given place
    public void insertNext(INode<E> p, E el) throws InvalidPlaceException {
        // Validate the placement position
        Node<E> v = validatePos(p);
        Node<E> newNode = new Node<E>(v, v.getNext(), el); // create new node
        v.getNext().setPrev(newNode); // amend nodes either side
        v.setNext(newNode);
        numEls++;
    }

    public E removeElement(INode<E> e) throws InvalidPlaceException {
        // Check out Rank is of a valid place in the list
        Node<E> n = validatePos(e);
        numEls--;
        // Identify the nodes either side of current position
        Node<E> nPrev = n.getPrev();
        Node<E> nNext = n.getNext();
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

    // Validate Position of a Placement
    protected Node<E> validatePos(INode<E> r) throws InvalidPlaceException {
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
            Node<E> test = (Node<E>) r;
            // Test to see if the placement has valid and has next and prev placements
            if((test.getNext() == null) || (test.getPrev() == null)){
                throw new InvalidPlaceException("Rank doesn't exist in the current list");
            }
            return test;
        } catch (ClassCastException e){
            throw new InvalidPlaceException("Rank is of incompatible type for this ranking list");
        }
    }

}
