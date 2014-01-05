package BST;

public class Stack<E extends Comparable<E>>
{
    /**
     * An element of the list, a tree {@link Node}.
     */
    public Node<E> top;
    
    /**
     * A reference to the rest of the stack.
     */
    public Stack<E> rest;
    
    /**
     * Create a stack from a tree node and another stack.
     * 
     * @param top the tree node to be the new top of the stack
     * @param stack another tack
     */
    public Stack(Node<E> top, Stack<E> stack)
    {
        this.top = top;
        this.rest = stack;
    }
}
