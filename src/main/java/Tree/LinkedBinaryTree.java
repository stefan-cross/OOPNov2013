package Tree;

import DLList.InvalidPlaceException;
import DLList.Node;
import DLList.List;

import java.util.Iterator;

public class LinkedBinaryTree<E> implements IBinaryTree<E> {

    protected BinaryTreeDNode<E> root;
    protected int size;

    public Node<E> left(Node<E> p) throws InvalidPlaceException, BoundaryViolationException {
        BinaryTreeDNode<E> pp = checkPlacement(p);
        Node<E> leftPos = pp.getLeft();
        if(leftPos == null){
            throw new BoundaryViolationException("No left child");
        }
        return leftPos;
    }

    public Node<E> right(Node<E> p) throws InvalidPlaceException, BoundaryViolationException {
        BinaryTreeDNode<E> pp = checkPlacement(p);
        Node<E> rightPos = pp.getRight();
        if(rightPos == null){
            throw new BoundaryViolationException("No left child");
        }
        return rightPos;
    }

    public boolean hasLeft(Node<E> p) throws InvalidPlaceException {
        BinaryTreeDNode<E> pp = checkPlacement(p);
        return (pp.getLeft() != null);
    }

    public boolean hasRight(Node<E> p) throws InvalidPlaceException {
        BinaryTreeDNode<E> pp = checkPlacement(p);
        return (pp.getRight() != null);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public Iterator<E> iterator() throws EmptyTreeException, BoundaryViolationException, InvalidPlaceException {
        Iterable<Node<E>> placements = placements();
        List<E> els = new List<E>();
        for(Node<E> pos: placements){
            els.addLast(pos.element());
        }
        return els.iterator();
    }

    public Iterable<Node<E>> placements() throws EmptyTreeException, BoundaryViolationException, InvalidPlaceException {
        List<Node<E>> placements = new List<Node<E>>();
        if(size != 0){
            preorderPlacements(root(), placements);
        }
        return placements;
    }

    protected void preorderPlacements(Node<E> p, List<Node<E>> pos) throws InvalidPlaceException, BoundaryViolationException {
        pos.addLast(p);
        if(hasLeft(p)){
            preorderPlacements(left(p), pos);
        }
        if(hasRight(p)){
            preorderPlacements(right(p), pos);
        }
    }

    public E replace(Node<E> p, E e) throws InvalidPlaceException {
        BinaryTreeDNode<E> pp = checkPlacement(p);
        E tmp = p.element();
        pp.setElement(e);
        return tmp;
    }

    public Node<E> root() throws EmptyTreeException {
        if(root == null){
            throw new EmptyTreeException("Tree is empty");
        }
        return root;
    }

    public Node<E> parent(Node<E> p) throws InvalidPlaceException, BoundaryViolationException {
        BinaryTreeDNode<E> pp = checkPlacement(p);
        Node<E> parentPos = pp.getParent();
        if(parentPos == null){
            throw new BoundaryViolationException("No parent");
        }
        return parentPos;
    }

    public Iterable<Node<E>> children(Node<E> p) throws InvalidPlaceException, BoundaryViolationException {
        List<Node<E>> children = new List<Node<E>>();
        if(hasLeft(p)){
            children.addLast(left(p));
        }
        if(hasRight(p)){
            children.addLast(right(p));
        }
        return children;
    }

    public boolean isInternal(Node<E> p) throws InvalidPlaceException {
        checkPlacement(p);
        return (hasLeft(p) || hasRight(p));
    }


    // Surely not needed if one can !isInternal...
    public boolean isExternal(Node<E> p) {
        return false;
    }

    public boolean isRoot(Node<E> p) throws InvalidPlaceException {
        checkPlacement(p);
        return (p == root);
    }


    public Node<E> add(E el) {
        int i = size() + 1;
        BinaryTreeDNode<E> p = new BinaryTreeDNode<E>(null, null, null, null);
        return null;
    }

    @Override
    public E remove() {
        return null;
    }

    private BinaryTreeDNode<E> checkPlacement(Node<E> p) throws InvalidPlaceException {
        if(p == null || !(p instanceof BinaryTreeDNode)){
            throw new InvalidPlaceException("Placement is invalid");
        }
        return (BinaryTreeDNode<E>)p;
    }



    // Additional methods
    public Node<E> sibling(Node<E> p) throws InvalidPlaceException, BoundaryViolationException {
        BinaryTreeDNode<E> pp = checkPlacement(p);
        BinaryTreeDNode<E> parentPos = pp.getParent();
        if(parentPos != null){
            BinaryTreeDNode<E> sibPos;
            BinaryTreeDNode<E> leftPos = parentPos.getLeft();
            if(leftPos == pp){
                sibPos = parentPos.getRight();
            } else {
                sibPos = parentPos.getLeft();
            }
            if(sibPos != null){
                return sibPos;
            }
        }
        throw new BoundaryViolationException("No Sibling");
    }

    public Node<E> insertLeft(Node<E> p, E e) throws InvalidPlaceException {
        BinaryTreeDNode<E> pp = checkPlacement(p);
        Node<E> leftPos = pp.getLeft();
        if(leftPos != null){
            throw new InvalidPlaceException("Placement already has a child to the left");
        }
        BinaryTreeDNode<E> qq = createPlacement(e, pp, null, null);
        pp.setLeft(qq);
        size++;
        return qq;
    }

    protected BinaryTreeDNode<E> createPlacement(E el, BinaryTreeDNode<E> parent, BinaryTreeDNode<E> left, BinaryTreeDNode<E> right){
        return new BinaryTreeDNode<E>(el, parent, left, right);
    }
    
    public E remove(Node<E> p) throws InvalidPlaceException {
        BinaryTreeDNode<E> pp = checkPlacement(p);
        BinaryTreeDNode<E> leftPos = pp.getLeft();
        BinaryTreeDNode<E> rightPos = pp.getRight();
        if(leftPos != null && rightPos != null){
            throw new InvalidPlaceException("Cannot remove node with two children");    
        }
        BinaryTreeDNode<E> qq;
        if(leftPos != null){
            qq = leftPos;    
        } else if(rightPos != null){
            qq = rightPos;    
        } else {
            qq = null;
        }
        if(pp == root){
            if(qq != null){
                qq.setParent(null);
            }
            root = qq;
        } else {
            BinaryTreeDNode<E> oo = pp.getParent();
            if(qq == oo.getLeft()){
                oo.setLeft(qq);
            } else {
                oo.setRight(qq);
            }
            if(qq != null){
                qq.setParent(oo);
            }
        }
        size--;
        return p.element();
    }

    public void attach(Node<E> p, IBinaryTree<E> t1, IBinaryTree<E> t2) throws InvalidPlaceException, EmptyTreeException {
        BinaryTreeDNode<E> pp = checkPlacement(p);
        if(isInternal(p)){
            throw new InvalidPlaceException("Cannot attach from internal placement");
        }
        int newSize = size + t1.size() + t2.size();
        if(!t1.isEmpty()){
            BinaryTreeDNode<E> r1 = checkPlacement(t1.root());
            pp.setLeft(r1);
            r1.setParent(pp);
        }
        if(!t2.isEmpty()){
            BinaryTreeDNode<E> r2 = checkPlacement(t2.root());
            pp.setRight(r2);
            r2.setParent(pp);
        }
        size = newSize;
    }

}
