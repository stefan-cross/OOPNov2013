import BST.BinarySearchTree;

import java.util.*;

public class BSTTest
{
    BinarySearchTree bst;
    

    BSTTest()
    {
        bst = new BinarySearchTree(1, 15);
    }
    
    void dump()
    {
        Iterator<Integer> iter = bst.iterator();
        
        while (iter.hasNext())
        {
            System.out.println(iter.next());
        }
    }
}
