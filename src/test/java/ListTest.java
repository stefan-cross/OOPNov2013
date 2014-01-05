import DLList.EmptyListException;
import DLList.InvalidPlaceException;
import DLList.List;
import junit.framework.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * User: stefancross
 * Date: 17/12/2013
 * Time: 22:12
 */
public class ListTest {
    // OVERVIEW: Testing the properties and operations of the PlacementList class

    private static List list = new List();

    public ListTest(){
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
    public void AddFirst() throws EmptyListException, InvalidPlaceException {
        list.addFirst("FrontTest");
        Assert.assertEquals(list.first().element(), "FrontTest");
    }

    @Test
    public void AddLast() throws InvalidPlaceException, EmptyListException {
        list.addLast("EndTest");
        Assert.assertEquals(list.last().element(), "EndTest");
    }

    @Test
    public void FrontPrev() throws EmptyListException, InvalidPlaceException {
        Assert.assertEquals(list.prev(list.first()).element(), "EndTest");
    }

    @Test
    public void LastNext() throws EmptyListException, InvalidPlaceException {
        Assert.assertEquals(list.next(list.last()).element(), "FrontTest");
    }

//    @Test
//    public void RemoveLast() throws EmptyListException, InvalidPlaceException {
//        placementList.removeElement(placementList.last());
//        Assert.assertEquals(placementList.last().element(), null);
//    }


}
