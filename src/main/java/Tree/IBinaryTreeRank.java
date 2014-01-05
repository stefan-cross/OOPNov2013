package Tree;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 26/12/2013
 * Time: 17:48
 */
public interface IBinaryTreeRank<E> {

    public void setElement(E e);

    public BinaryTreeDNode<E> getLeft();

    public void setLeft(BinaryTreeDNode<E> p);

    public BinaryTreeDNode<E> getRight();

    public void setRight(BinaryTreeDNode<E> p);

    public BinaryTreeDNode<E> getParent();

    public void setParent(BinaryTreeDNode<E> p);
}
