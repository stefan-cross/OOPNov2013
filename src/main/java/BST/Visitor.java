package BST;
/**
 * An interface for a tree visitor
 * 
 * @author  Daniel W.H. James
 * @version OOP May 2011
 */
public interface Visitor<E>
{
    /**
     * @param elem
     */
    public void visit(E elem);
}
