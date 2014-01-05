package BST;

public interface Tree<E extends Comparable<E>>
{
    /**
     * Get the size of the tree
     * 
     * @return size of the tree
     */
    public int size();
    
    /**
     * Test if an integer occurs in the tree.
     * 
     * @param elem an integer to check
     * @return true iff the element occurs
     */
    public boolean member(E elem);
    
    /**
     * Insert an integer into the tree
     * 
     * @param elem an integer to insert
     * @return
     */
    public Tree<E> insert(E elem);
    
    /**
     * Make an in-order traveral of this tree
     * using a visitor.
     * 
     * @param v a visitor
     */
    public void inorder(Visitor<E> v);
    
    /**
     * @param stack
     * @return
     */
    public Stack<E> spine(Stack<E> stack);
    
    /**
     * @param depth
     */
    public void dump(int depth);
}
