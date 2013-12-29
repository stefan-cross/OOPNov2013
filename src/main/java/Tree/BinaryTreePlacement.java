package Tree;

import DoubleLinkedList.InvalidPlaceException;
import DoubleLinkedList.Placement;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 26/12/2013
 * Time: 18:05
 */
public class BinaryTreePlacement<E> extends Placement<E> implements IBinaryTreeRank<E> {

    private E element;
    private BinaryTreePlacement<E> left, right, parent;

    public BinaryTreePlacement(E element, BinaryTreePlacement<E> parent, BinaryTreePlacement<E> left, BinaryTreePlacement<E> right){
        setElement(element);
        setParent(parent);
        setLeft(left);
        setRight(right);
    }


    
    public E element() throws InvalidPlaceException {
        return element;
    }

    public void setElement(E e) {
        element = e;
    }

    public BinaryTreePlacement<E> getLeft() {
        return left;
    }

    
    public void setLeft(BinaryTreePlacement<E> p) {
        left = p;
    }

    
    public BinaryTreePlacement<E> getRight() {
        return right;
    }

    
    public void setRight(BinaryTreePlacement<E> p) {
        right = p;
    }

    
    public BinaryTreePlacement<E> getParent() {
        return parent;
    }

    
    public void setParent(BinaryTreePlacement<E> p) {
        parent = p;
    }
}
