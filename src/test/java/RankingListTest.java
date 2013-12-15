
import Library.ITrack;
import Library.Track;

import RankingList.RankingList;
import RankingList.IRank;
import RankingList.EmptyListException;
import RankingList.InvalidPlaceException;

import junit.framework.Assert;
import org.junit.Test;

public class RankingListTest {

    private static RankingList rankingList = new RankingList();
    private static Track t, t2;

    public RankingListTest(){
        t = new Track();
        t.setTrack("Cream", "I feel free");

        t2 = new Track();
        t2.setTrack("Pink Floyd", "Comfortably numb");
    }

    @Test
    public void RankingListIsEmpty(){
        Assert.assertTrue(rankingList.isEmpty());
    }

    @Test
    public void RankingListAddFirstElement() throws EmptyListException, InvalidPlaceException {
        rankingList.addFirst(t);
        Assert.assertEquals(rankingList.first().element().toString(), t.toString());
    }

    @Test
    public void RankingListAddNewFirstElement() throws EmptyListException, InvalidPlaceException {
        rankingList.addFirst(t2);
        Assert.assertEquals(rankingList.first().element().toString(), t2.toString());
    }

    @Test
    public void RankingListLastElement() throws EmptyListException, InvalidPlaceException {
        Assert.assertEquals(rankingList.last().element().toString(), t.toString());
    }





}
