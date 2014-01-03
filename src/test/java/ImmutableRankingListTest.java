
import ImmutableDoubleLinkedList.ImmutablePlacementList;
import Library.Track;

import DoubleLinkedList.PlacementList;
import DoubleLinkedList.EmptyListException;
import DoubleLinkedList.InvalidPlaceException;

import junit.framework.Assert;
import org.junit.Test;

public class ImmutableRankingListTest {

    private static ImmutablePlacementList rankingList = new ImmutablePlacementList();
    private static Track t, t2, t3;

    public ImmutableRankingListTest(){
        t = new Track();
        t.setTrack("Cream", "I feel free");

        t2 = new Track();
        t2.setTrack("Pink Floyd", "Comfortably numb");

        t3 = new Track();
        t3.setTrack("Syd Barrett", "Baby Lemonade");
    }

    @Test
    public void RankingListIsEmpty(){
        Assert.assertTrue(rankingList.isEmpty());
    }

    //TODO adding to last and first isnt tying up currently, although adding to front or end
    // works according to front or end, you are not able to trace back from the opposite direction
    @Test
    public void RankingListAddFirstElement() throws ImmutableDoubleLinkedList.InvalidPlaceException, ImmutableDoubleLinkedList.EmptyListException {
        rankingList.addFirst(t);
        Assert.assertEquals(rankingList.first().element().toString(), t.toString());
    }

    @Test
    public void RankingListFirstIsLast() throws ImmutableDoubleLinkedList.EmptyListException, ImmutableDoubleLinkedList.InvalidPlaceException {
        Assert.assertEquals(rankingList.first().element().toString(), rankingList.last().element().toString());
    }

    @Test
    public void RankingListGetAfterFirst() throws ImmutableDoubleLinkedList.EmptyListException, ImmutableDoubleLinkedList.InvalidPlaceException {
        Assert.assertNull(rankingList.first().getNext().element());
    }

    @Test
    public void RankingListGetAfterLast() throws ImmutableDoubleLinkedList.EmptyListException, ImmutableDoubleLinkedList.InvalidPlaceException {
        Assert.assertNull(rankingList.last().getNext().element());
    }

    @Test
    public void RankingListAddNewFirstElement() throws ImmutableDoubleLinkedList.EmptyListException, ImmutableDoubleLinkedList.InvalidPlaceException {
        rankingList.addFirst(t2);
        Assert.assertEquals(rankingList.first().element().toString(), t2.toString());
        Assert.assertEquals(rankingList.last().element().toString(), t.toString());
    }

    @Test
    public void RankingListLastElement() throws ImmutableDoubleLinkedList.EmptyListException, ImmutableDoubleLinkedList.InvalidPlaceException {
        Assert.assertEquals(rankingList.last().element().toString(), t.toString());
    }

    @Test
    public void RankingListAddLastElement() throws ImmutableDoubleLinkedList.InvalidPlaceException, ImmutableDoubleLinkedList.EmptyListException {
        rankingList.addLast(t3);
        Assert.assertEquals(rankingList.last().element().toString(), t3.toString());
    }





}
