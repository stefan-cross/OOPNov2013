package DLList;

import java.util.Iterator;

public interface IList<E> extends Iterable<E> {

    // Returns the number of elements in the placementList
    public int size();

    // Returns boolean value depending on elements in placementList
    public Boolean isEmpty();

    // Returns the 1st element of the placementList
    public INode<E> first() throws EmptyListException;

    // Returns the last element of the placementList
    public INode<E> last() throws EmptyListException;

    // Inserts and element at the front of the placementList
    public void addFirst(E e) throws InvalidPlaceException;

    // Inserts and element at the end of a placementList
    public void addLast(E e) throws InvalidPlaceException;

    // Returns the next element of the placementList given a place in the placementList
    public INode<E> next(INode<E> rank) throws EmptyListException, InvalidPlaceException;

    // Returns the previous element of the placementList given a place in the placementList
    public INode<E> prev(INode<E> prev) throws InvalidPlaceException;

    // Inserts and element behind a given placement in the placementList
    public void insertPrev(INode<E> p, E el) throws InvalidPlaceException;

    // Inserts and element in front of a given placement in the placementList
    public void insertNext(INode<E> p, E el) throws InvalidPlaceException;

    // Iterates over elements in the placementList
    public Iterator<E> iterator();
}
