package Tree;

import DLList.InvalidPlaceException;
import DLList.DNode;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 26/12/2013
 * Time: 17:40
 */
public interface IBinaryTree<E> extends ITree<E> {

    public DNode<E> left(DNode<E> p) throws InvalidPlaceException, BoundaryViolationException;

    public DNode<E> right(DNode<E> p) throws InvalidPlaceException, BoundaryViolationException;

    public boolean hasLeft(DNode<E> p) throws InvalidPlaceException;

    public boolean hasRight(DNode<E> p) throws InvalidPlaceException;

}
