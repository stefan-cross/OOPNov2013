package BST;

public class Node<E extends Comparable<E>> implements Tree<E>
{
    public Tree<E> left;
    public E       item;
    public Tree<E> right;

    public Node(Tree<E> left, E item, Tree<E> right)
    {
        this.left  = left;
        this.item  = item;
        this.right = right;
    }
    
    public int size()
    {
        return left.size() + 1 + right.size();
    }

    public boolean member(E elem)
    {
        if (elem.compareTo(item) < 0)
            return left.member(elem);
        else if (elem.compareTo(item) == 0)
            return true;
        else
            return right.member(elem);
    }
    
    public Tree<E> insert(E elem)
    {
        if (elem.compareTo(item) < 0)
            left  = left. insert(elem);
        else 
            right = right.insert(elem);
        return this;
    }
    
    public void inorder(Visitor<E> v)
    {
        left.inorder(v);
        v.visit(item);
        right.inorder(v);
    }
    
    public Stack<E> spine(Stack<E> stack)
    {
        return left.spine(new Stack<E>(this, stack));
    }
    
    public void dump(int depth)
    {
        left.dump(depth + 1);
        for (int i = 0; i < depth; i++)
            System.out.print("    ");
        System.out.println(item);
        right.dump(depth + 1);
    }
}
