package Tree;

public interface IBinaryTreeRank<E> {

    public void setElement(E e);

    public BinaryTreeDNode<E> getLeft();

    public void setLeft(BinaryTreeDNode<E> p);

    public BinaryTreeDNode<E> getRight();

    public void setRight(BinaryTreeDNode<E> p);

    public BinaryTreeDNode<E> getParent();

    public void setParent(BinaryTreeDNode<E> p);
}
