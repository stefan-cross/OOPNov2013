package Tree;

import DLList.InvalidPlaceException;
import DLList.Node;

public interface IBinaryTree<E> extends ITree<E> {

    public Node<E> left(Node<E> p) throws InvalidPlaceException, BoundaryViolationException;

    public Node<E> right(Node<E> p) throws InvalidPlaceException, BoundaryViolationException;

    public boolean hasLeft(Node<E> p) throws InvalidPlaceException;

    public boolean hasRight(Node<E> p) throws InvalidPlaceException;

}
