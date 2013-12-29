package Tree;

import DoubleLinkedList.IPlacement;
import DoubleLinkedList.Placement;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 26/12/2013
 * Time: 17:48
 */
public interface IBinaryTreeRank<E> {

    public void setElement(E e);

    public BinaryTreePlacement<E> getLeft();

    public void setLeft(BinaryTreePlacement<E> p);

    public BinaryTreePlacement<E> getRight();

    public void setRight(BinaryTreePlacement<E> p);

    public BinaryTreePlacement<E> getParent();

    public void setParent(BinaryTreePlacement<E> p);
}
