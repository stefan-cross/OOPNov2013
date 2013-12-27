package Tree;

import DoubleLinkedList.InvalidPlaceException;
import DoubleLinkedList.Placement;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 26/12/2013
 * Time: 17:28
 */
public interface ITree<E> {

    public int size();

    public boolean isEmpty();

    public Iterator<E> iterator() throws EmptyTreeException, BoundaryViolationException, InvalidPlaceException;

    public Iterable<Placement<E>> placements() throws EmptyTreeException, BoundaryViolationException, InvalidPlaceException;

    public E replace(Placement<E> p, E e) throws InvalidPlaceException;

    public Placement<E> root() throws EmptyTreeException;

    public Placement<E> parent(Placement<E> p) throws InvalidPlaceException, BoundaryViolationException;

    public Iterable<Placement<E>> children(Placement<E> p) throws InvalidPlaceException, BoundaryViolationException;

    public boolean isInternal(Placement<E> p) throws InvalidPlaceException;

    public boolean isExternal(Placement<E> p);

    public boolean isRoot(Placement<E> p) throws InvalidPlaceException;
}
