import DoubleLinkedList.EmptyListException;
import DoubleLinkedList.InvalidPlaceException;
import DoubleLinkedList.PlacementList;
import ImmutableDoubleLinkedList.ImmutablePlacementList;
import junit.framework.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 31/12/2013
 * Time: 15:03
 */
public class ImmutableListTest {

    private static ImmutablePlacementList list = new ImmutablePlacementList();

    public ImmutableListTest(){
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void noElements(){
        Assert.assertEquals(list.size(), 0);
    }

    @Test
    public void ListToStringNull(){
        Assert.assertNull(list.toString(), null);
    }

    @Test
    public void AddFirst() throws ImmutableDoubleLinkedList.InvalidPlaceException, ImmutableDoubleLinkedList.EmptyListException {
        list.addFirst("FrontTest");
        Assert.assertEquals(list.first().element(), "FrontTest");
    }

    @Test
    public void AddLast() throws ImmutableDoubleLinkedList.InvalidPlaceException, ImmutableDoubleLinkedList.EmptyListException {
        list.addLast("EndTest");
        Assert.assertEquals(list.last().element(), "EndTest");
    }

    @Test
    public void FrontPrev() throws ImmutableDoubleLinkedList.InvalidPlaceException, ImmutableDoubleLinkedList.EmptyListException {
        Assert.assertEquals(list.last().element(), "EndTest");
    }

    @Test
    public void LastNext() throws ImmutableDoubleLinkedList.InvalidPlaceException, ImmutableDoubleLinkedList.EmptyListException {
        Assert.assertEquals(list.first().element(), "FrontTest");
    }
}
