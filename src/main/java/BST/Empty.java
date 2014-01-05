package BST;

public class Empty<E extends Comparable<E>> implements Tree<E>
{
    private static Tree empty = new Empty();
    
    public Empty()
    {
    }
    
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> Tree<T> getEmpty()
    {
        return empty;
    }
    
    public int size()
    {
        return 0;
    }

    public boolean member(E elem)
    {
        return false;
    }
    
    @SuppressWarnings("unchecked")
    public Tree<E> insert(E elem)
    {
        return new Node<E>(Empty.<E>getEmpty(), elem, Empty.<E>getEmpty());
    }
    
    public void inorder(Visitor<E> v)
    {
        return;
    }
    
    public Stack<E> spine(Stack<E> stack)
    {
        return stack;
    }
    
    public void dump(int depth)
    {
    }
}
