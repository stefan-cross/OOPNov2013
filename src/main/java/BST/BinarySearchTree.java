package BST;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinarySearchTree
{
    private Tree<Integer> root;
    
    public BinarySearchTree()
    {
        root = Empty.<Integer>getEmpty();
    }

    public BinarySearchTree(int l, int r)
    {
        root = create(l, r);
    }
    
    private Tree<Integer> create(int l, int r)
    {
        if (l > r)
            return Empty.<Integer>getEmpty();
        else
        {
            int m = (l + r) / 2;
            
            return new Node<Integer>(create(l, m-1), m, create(m+1, r));
        }
    }
    
    public int size()
    {
        return root.size();
    }
    
    public boolean member(int elem)
    {
        return root.member(elem);
    }
    
    public void print()
    {
        root.inorder(new Visitor<Integer>()
            { 
                public void visit(Integer item) { System.out.println(item); }
            });
    }
    
    public Iterator<Integer> iterator()
    {
        return new Iterator<Integer>()
        {
            Stack<Integer> stack = root.spine(null);
            
            public boolean hasNext()
            {
                return stack != null;
            }
            
            public Integer next()
            {
                if (stack == null)
                {
                    throw new NoSuchElementException();
                }
                else
                {
                    int elem = stack.top.item;
                    stack = stack.top.right.spine(stack.rest);
                    return elem;
                }
            }
            
            public void remove()
            {
                throw new UnsupportedOperationException();
            }
        };
    }
    
    void dump()
    {
        root.dump(0);
    }
}
