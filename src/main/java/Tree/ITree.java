package Tree;

import DLList.Node;
import DLList.InvalidPlaceException;

import java.util.Iterator;

public interface ITree<E> {

    public int size();

    public boolean isEmpty();

    public Iterator<E> iterator() throws EmptyTreeException, BoundaryViolationException, InvalidPlaceException;

    public Iterable<Node<E>> placements() throws EmptyTreeException, BoundaryViolationException, InvalidPlaceException;

    public E replace(Node<E> p, E e) throws InvalidPlaceException;

    public Node<E> root() throws EmptyTreeException;

    public Node<E> parent(Node<E> p) throws InvalidPlaceException, BoundaryViolationException;

    public Iterable<Node<E>> children(Node<E> p) throws InvalidPlaceException, BoundaryViolationException;

    public boolean isInternal(Node<E> p) throws InvalidPlaceException;

    public boolean isExternal(Node<E> p);

    public boolean isRoot(Node<E> p) throws InvalidPlaceException;

    public Node<E> add(E el);

    public E remove();
}
