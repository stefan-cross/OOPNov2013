package Tree;

import DoubleLinkedList.InvalidPlaceException;
import DoubleLinkedList.Placement;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 26/12/2013
 * Time: 17:40
 */
public interface IBinaryTree<E> extends ITree<E> {

    public Placement<E> left(Placement<E> p) throws InvalidPlaceException, BoundaryViolationException;

    public Placement<E> right(Placement<E> p) throws InvalidPlaceException, BoundaryViolationException;

    public boolean hasLeft(Placement<E> p) throws InvalidPlaceException;

    public boolean hasRight(Placement<E> p) throws InvalidPlaceException;

}
