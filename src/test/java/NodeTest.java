import DoubleLinkedList.InvalidPlaceException;
import DoubleLinkedList.Node;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 17/12/2013
 * Time: 22:13
 */
public class NodeTest {
    // Overview: Testing the property and functionality of Nodes for use in lists

    private Node n;

    public NodeTest(){
        n = new Node(null, null, null);
    }

    @Test
    public void NullNodeSetup() throws InvalidPlaceException {
        Assert.assertNull(n.getNext());
        Assert.assertNull(n.getPrev());
    }

    @Test
    public void FrontNodeSetup(){
        //TODO is this the best way to test generics?
        Node<Object> next = null;
        next.setElement("Test");

        n = new Node(null, next, null);
        Assert.assertEquals(null, n.getPrev());
        Assert.assertEquals("Test", n.getNext());
        // Cant currently test the element is null as .element() method throws and error is element is null
        // so write a better exception or test for exception...
        //TODO how to test exceptions?

    }


}
