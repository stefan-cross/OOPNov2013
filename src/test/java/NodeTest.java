import DoubleLinkedList.InvalidPlaceException;
import DoubleLinkedList.Placement;
import junit.framework.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 17/12/2013
 * Time: 22:13
 */
public class NodeTest {
    // Overview: Testing the property and functionality of Nodes for use in lists

    private Placement node;

    public NodeTest(){
        node = new Placement(null, null, null);
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void NullNodeSetup() throws InvalidPlaceException {
        Assert.assertNull(node.getNext());
        Assert.assertNull(node.getPrev());
    }

    @Test
    public void NodeInvalidPlaceException() throws InvalidPlaceException{
        exception.expect(InvalidPlaceException.class);
        exception.expectMessage("Invalid place in placementList, or placementList is empty");
        node.element();
    }
}
