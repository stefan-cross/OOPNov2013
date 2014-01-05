package Tree;

import DLList.InvalidPlaceException;
import DLList.DNode;
import DLList.List;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 26/12/2013
 * Time: 18:49
 */
public class LinkedBinaryTree<E> implements IBinaryTree<E> {

    protected BinaryTreeDNode<E> root;
    protected int size;

    public DNode<E> left(DNode<E> p) throws InvalidPlaceException, BoundaryViolationException {
        BinaryTreeDNode<E> pp = checkPlacement(p);
        DNode<E> leftPos = pp.getLeft();
        if(leftPos == null){
            throw new BoundaryViolationException("No left child");
        }
        return leftPos;
    }

    public DNode<E> right(DNode<E> p) throws InvalidPlaceException, BoundaryViolationException {
        BinaryTreeDNode<E> pp = checkPlacement(p);
        DNode<E> rightPos = pp.getRight();
        if(rightPos == null){
            throw new BoundaryViolationException("No left child");
        }
        return rightPos;
    }

    public boolean hasLeft(DNode<E> p) throws InvalidPlaceException {
        BinaryTreeDNode<E> pp = checkPlacement(p);
        return (pp.getLeft() != null);
    }

    public boolean hasRight(DNode<E> p) throws InvalidPlaceException {
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
        Iterable<DNode<E>> placements = placements();
        List<E> els = new List<E>();
        for(DNode<E> pos: placements){
            els.addLast(pos.element());
        }
        return els.iterator();
    }

    public Iterable<DNode<E>> placements() throws EmptyTreeException, BoundaryViolationException, InvalidPlaceException {
        List<DNode<E>> placements = new List<DNode<E>>();
        if(size != 0){
            preorderPlacements(root(), placements);
        }
        return placements;
    }

    protected void preorderPlacements(DNode<E> p, List<DNode<E>> pos) throws InvalidPlaceException, BoundaryViolationException {
        pos.addLast(p);
        if(hasLeft(p)){
            preorderPlacements(left(p), pos);
        }
        if(hasRight(p)){
            preorderPlacements(right(p), pos);
        }
    }

    public E replace(DNode<E> p, E e) throws InvalidPlaceException {
        BinaryTreeDNode<E> pp = checkPlacement(p);
        E tmp = p.element();
        pp.setElement(e);
        return tmp;
    }

    public DNode<E> root() throws EmptyTreeException {
        if(root == null){
            throw new EmptyTreeException("Tree is empty");
        }
        return root;
    }

    public DNode<E> parent(DNode<E> p) throws InvalidPlaceException, BoundaryViolationException {
        BinaryTreeDNode<E> pp = checkPlacement(p);
        DNode<E> parentPos = pp.getParent();
        if(parentPos == null){
            throw new BoundaryViolationException("No parent");
        }
        return parentPos;
    }

    public Iterable<DNode<E>> children(DNode<E> p) throws InvalidPlaceException, BoundaryViolationException {
        List<DNode<E>> children = new List<DNode<E>>();
        if(hasLeft(p)){
            children.addLast(left(p));
        }
        if(hasRight(p)){
            children.addLast(right(p));
        }
        return children;
    }

    public boolean isInternal(DNode<E> p) throws InvalidPlaceException {
        checkPlacement(p);
        return (hasLeft(p) || hasRight(p));
    }


    // Surely not needed if one can !isInternal...
    public boolean isExternal(DNode<E> p) {
        return false;
    }

    public boolean isRoot(DNode<E> p) throws InvalidPlaceException {
        checkPlacement(p);
        return (p == root);
    }


    public DNode<E> add(E el) {
        int i = size() + 1;
        BinaryTreeDNode<E> p = new BinaryTreeDNode<E>(null, null, null, null);
        return null;
    }

    @Override
    public E remove() {
        return null;
    }

    private BinaryTreeDNode<E> checkPlacement(DNode<E> p) throws InvalidPlaceException {
        if(p == null || !(p instanceof BinaryTreeDNode)){
            throw new InvalidPlaceException("Placement is invalid");
        }
        return (BinaryTreeDNode<E>)p;
    }



    // Additional methods
    public DNode<E> sibling(DNode<E> p) throws InvalidPlaceException, BoundaryViolationException {
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

    public DNode<E> insertLeft(DNode<E> p, E e) throws InvalidPlaceException {
        BinaryTreeDNode<E> pp = checkPlacement(p);
        DNode<E> leftPos = pp.getLeft();
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
    
    public E remove(DNode<E> p) throws InvalidPlaceException {
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

    public void attach(DNode<E> p, IBinaryTree<E> t1, IBinaryTree<E> t2) throws InvalidPlaceException, EmptyTreeException {
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
