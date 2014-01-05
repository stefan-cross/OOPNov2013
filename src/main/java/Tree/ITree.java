package Tree;

import DLList.DNode;
import DLList.InvalidPlaceException;

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

    public Iterable<DNode<E>> placements() throws EmptyTreeException, BoundaryViolationException, InvalidPlaceException;

    public E replace(DNode<E> p, E e) throws InvalidPlaceException;

    public DNode<E> root() throws EmptyTreeException;

    public DNode<E> parent(DNode<E> p) throws InvalidPlaceException, BoundaryViolationException;

    public Iterable<DNode<E>> children(DNode<E> p) throws InvalidPlaceException, BoundaryViolationException;

    public boolean isInternal(DNode<E> p) throws InvalidPlaceException;

    public boolean isExternal(DNode<E> p);

    public boolean isRoot(DNode<E> p) throws InvalidPlaceException;

    public DNode<E> add(E el);

    public E remove();
}
