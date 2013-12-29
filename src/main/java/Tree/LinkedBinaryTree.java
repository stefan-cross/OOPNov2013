package Tree;

import DoubleLinkedList.InvalidPlaceException;
import DoubleLinkedList.Placement;
import DoubleLinkedList.PlacementList;
import com.sun.source.tree.BinaryTree;

import javax.naming.BinaryRefAddr;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 26/12/2013
 * Time: 18:49
 */
public class LinkedBinaryTree<E> implements IBinaryTree<E> {

    protected BinaryTreePlacement<E> root;
    protected int size;

    public Placement<E> left(Placement<E> p) throws InvalidPlaceException, BoundaryViolationException {
        BinaryTreePlacement<E> pp = checkPlacement(p);
        Placement<E> leftPos = pp.getLeft();
        if(leftPos == null){
            throw new BoundaryViolationException("No left child");
        }
        return leftPos;
    }

    public Placement<E> right(Placement<E> p) throws InvalidPlaceException, BoundaryViolationException {
        BinaryTreePlacement<E> pp = checkPlacement(p);
        Placement<E> rightPos = pp.getRight();
        if(rightPos == null){
            throw new BoundaryViolationException("No left child");
        }
        return rightPos;
    }

    public boolean hasLeft(Placement<E> p) throws InvalidPlaceException {
        BinaryTreePlacement<E> pp = checkPlacement(p);
        return (pp.getLeft() != null);
    }

    public boolean hasRight(Placement<E> p) throws InvalidPlaceException {
        BinaryTreePlacement<E> pp = checkPlacement(p);
        return (pp.getRight() != null);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public Iterator<E> iterator() throws EmptyTreeException, BoundaryViolationException, InvalidPlaceException {
        Iterable<Placement<E>> placements = placements();
        PlacementList<E> els = new PlacementList<E>();
        for(Placement<E> pos: placements){
            els.addLast(pos.element());
        }
        return els.iterator();
    }

    public Iterable<Placement<E>> placements() throws EmptyTreeException, BoundaryViolationException, InvalidPlaceException {
        PlacementList<Placement<E>> placements = new PlacementList<Placement<E>>();
        if(size != 0){
            preorderPlacements(root(), placements);
        }
        return placements;
    }

    protected void preorderPlacements(Placement<E> p, PlacementList<Placement<E>> pos) throws InvalidPlaceException, BoundaryViolationException {
        pos.addLast(p);
        if(hasLeft(p)){
            preorderPlacements(left(p), pos);
        }
        if(hasRight(p)){
            preorderPlacements(right(p), pos);
        }
    }

    public E replace(Placement<E> p, E e) throws InvalidPlaceException {
        BinaryTreePlacement<E> pp = checkPlacement(p);
        E tmp = p.element();
        pp.setElement(e);
        return tmp;
    }

    public Placement<E> root() throws EmptyTreeException {
        if(root == null){
            throw new EmptyTreeException("Tree is empty");
        }
        return root;
    }

    public Placement<E> parent(Placement<E> p) throws InvalidPlaceException, BoundaryViolationException {
        BinaryTreePlacement<E> pp = checkPlacement(p);
        Placement<E> parentPos = pp.getParent();
        if(parentPos == null){
            throw new BoundaryViolationException("No parent");
        }
        return parentPos;
    }

    public Iterable<Placement<E>> children(Placement<E> p) throws InvalidPlaceException, BoundaryViolationException {
        PlacementList<Placement<E>> children = new PlacementList<Placement<E>>();
        if(hasLeft(p)){
            children.addLast(left(p));
        }
        if(hasRight(p)){
            children.addLast(right(p));
        }
        return children;
    }

    public boolean isInternal(Placement<E> p) throws InvalidPlaceException {
        checkPlacement(p);
        return (hasLeft(p) || hasRight(p));
    }


    // Surely not needed if one can !isInternal...
    public boolean isExternal(Placement<E> p) {
        return false;
    }

    public boolean isRoot(Placement<E> p) throws InvalidPlaceException {
        checkPlacement(p);
        return (p == root);
    }


    public Placement<E> add(E el) {
        int i = size() + 1;
        BinaryTreePlacement<E> p = new BinaryTreePlacement<E>(null, null, null, null);
        return null;
    }

    @Override
    public E remove() {
        return null;
    }

    private BinaryTreePlacement<E> checkPlacement(Placement<E> p) throws InvalidPlaceException {
        if(p == null || !(p instanceof BinaryTreePlacement)){
            throw new InvalidPlaceException("Placement is invalid");
        }
        return (BinaryTreePlacement<E>)p;
    }



    // Additional methods
    public Placement<E> sibling(Placement<E> p) throws InvalidPlaceException, BoundaryViolationException {
        BinaryTreePlacement<E> pp = checkPlacement(p);
        BinaryTreePlacement<E> parentPos = pp.getParent();
        if(parentPos != null){
            BinaryTreePlacement<E> sibPos;
            BinaryTreePlacement<E> leftPos = parentPos.getLeft();
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

    public Placement<E> insertLeft(Placement<E> p, E e) throws InvalidPlaceException {
        BinaryTreePlacement<E> pp = checkPlacement(p);
        Placement<E> leftPos = pp.getLeft();
        if(leftPos != null){
            throw new InvalidPlaceException("Placement already has a child to the left");
        }
        BinaryTreePlacement<E> qq = createPlacement(e, pp, null, null);
        pp.setLeft(qq);
        size++;
        return qq;
    }

    protected BinaryTreePlacement<E> createPlacement(E el, BinaryTreePlacement<E> parent, BinaryTreePlacement<E> left, BinaryTreePlacement<E> right){
        return new BinaryTreePlacement<E>(el, parent, left, right);
    }
    
    public E remove(Placement<E> p) throws InvalidPlaceException {
        BinaryTreePlacement<E> pp = checkPlacement(p);
        BinaryTreePlacement<E> leftPos = pp.getLeft();
        BinaryTreePlacement<E> rightPos = pp.getRight();
        if(leftPos != null && rightPos != null){
            throw new InvalidPlaceException("Cannot remove node with two children");    
        }
        BinaryTreePlacement<E> qq;
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
            BinaryTreePlacement<E> oo = pp.getParent();
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

    public void attach(Placement<E> p, IBinaryTree<E> t1, IBinaryTree<E> t2) throws InvalidPlaceException, EmptyTreeException {
        BinaryTreePlacement<E> pp = checkPlacement(p);
        if(isInternal(p)){
            throw new InvalidPlaceException("Cannot attach from internal placement");
        }
        int newSize = size + t1.size() + t2.size();
        if(!t1.isEmpty()){
            BinaryTreePlacement<E> r1 = checkPlacement(t1.root());
            pp.setLeft(r1);
            r1.setParent(pp);
        }
        if(!t2.isEmpty()){
            BinaryTreePlacement<E> r2 = checkPlacement(t2.root());
            pp.setRight(r2);
            r2.setParent(pp);
        }
        size = newSize;
    }

}
