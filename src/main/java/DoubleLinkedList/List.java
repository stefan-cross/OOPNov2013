package DoubleLinkedList;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 13/12/2013
 * Time: 16:55
 * To change this template use File | Settings | File Templates.
 */
public class List<E> implements IList<E> {

    private int numEls;
    protected Node<E> front, end;

    public List(){
        numEls = 0;
        front = new Node<E>(null, null, null);
        end = new Node<E>(null, front, null);
        // Leading start element now points to the last el end
        front.setPrev(end);
    }

    protected Node<E> valPosition(IPlacement<E> r) throws InvalidPlaceException {
        if(r == null){
            throw new InvalidPlaceException("A null value was given to the list");
        }
        if((r == front) || (r == end)){
            throw new InvalidPlaceException("Front or End places are not valid ranks");
        }
        try{
            // Cast our rank to a node if its not fallen foul of the previous potential issues
            Node<E> test = (Node<E>) r;
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

    public IPlacement<E> first() throws EmptyListException {
        if(isEmpty()){
            throw new EmptyListException("There is no first rank as the list is empty");
        }
        return front.getPrev();
    }

    public IPlacement<E> last() throws EmptyListException{
        if(isEmpty()){
            throw new EmptyListException("There is no last rank as the list is empty");
        }
        return end.getNext();
    }

    public IPlacement<E> next(IPlacement<E> rank) throws EmptyListException, InvalidPlaceException {
        Node<E> n = valPosition(rank);
        Node<E> next = n.getNext();

        if(next == front){
            throw new InvalidPlaceException("Next item is the front of the list, can not proceed");
        }

        return next;
    }

    //TODO write tests around this.. and all others for that matter
    public IPlacement<E> prev(IPlacement<E> rank) throws InvalidPlaceException {
        Node<E> n = valPosition(rank);
        Node<E> prev = n.getPrev();

        if(prev == end){
            throw new InvalidPlaceException("Prev item is the end of the list, can not proceed");
        }

        return prev;
    }


    public void addFirst(E element){
        Node<E> newNode = new Node<E>(front.getPrev(), front, element);
        front.getPrev().setNext(newNode);
        front.setPrev(newNode);
        numEls++;
    }

    public void addLast(E element) throws InvalidPlaceException {
        Node<E> newNode = new Node<E>(end, end.getNext(), element);
        end.getNext().setPrev(newNode);
        end.setNext(newNode);
        numEls++;
    }


    public void insertPrev(IPlacement<E> p, E el) throws InvalidPlaceException {
        Node<E> v = valPosition(p);
        Node<E> newNode = new Node<E>(v.getPrev(), v, el);
        v.getPrev().setNext(newNode);
        v.setPrev(newNode);
        numEls++;
    }

    public void insertNext(IPlacement<E> p, E el) throws InvalidPlaceException {
        Node<E> v = valPosition(p);
        Node<E> newNode = new Node<E>(v, v.getNext(), el);
        v.getNext().setPrev(newNode);
        v.setNext(newNode);
        numEls++;
    }


    public void addElement(IPlacement<E> r, E element) throws InvalidPlaceException {
        Node<E> n = valPosition(r);
        Node<E> newNode = new Node<E>(n.getPrev(), n, element);
        n.getPrev().setNext(newNode);
        n.setPrev(newNode);
        numEls++;

    }

    public E removeElement(IPlacement<E> e) throws InvalidPlaceException {

        // Check out Rank is of a valid place in the list
        Node<E> n = valPosition(e);
        // Decrease the number of elements in the list
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

    @Override
    public Iterator<E> iterator(){
        return new ElementIterator<E>(this);
    }

    public static <E> String toString(List<E> r) {
        Iterator<E> i = r.iterator();
        String s = "";

        while(i.hasNext()){
            s += i.next();
            if(i.hasNext()){
                s += "\n";
            }
        }
        s += "";
        return s;
    }

    public String toString(E e){
        String s = e.toString();
        return s;
    }

}
