package Tree;

import DLList.InvalidPlaceException;
import DLList.Node;

public class BinaryTreeDNode<E> extends Node<E> implements IBinaryTreeRank<E> {

    private E element;
    private BinaryTreeDNode<E> left, right, parent;

    public BinaryTreeDNode(E element, BinaryTreeDNode<E> parent, BinaryTreeDNode<E> left, BinaryTreeDNode<E> right){
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

    public BinaryTreeDNode<E> getLeft() {
        return left;
    }

    
    public void setLeft(BinaryTreeDNode<E> p) {
        left = p;
    }

    
    public BinaryTreeDNode<E> getRight() {
        return right;
    }

    
    public void setRight(BinaryTreeDNode<E> p) {
        right = p;
    }

    
    public BinaryTreeDNode<E> getParent() {
        return parent;
    }

    
    public void setParent(BinaryTreeDNode<E> p) {
        parent = p;
    }
}
