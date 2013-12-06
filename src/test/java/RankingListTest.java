import RankingList.Application;
import RankingList.Track;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 06/12/2013
 * Time: 12:06
 * To change this template use File | Settings | File Templates.
 */
public class RankingListTest {

    private static Track t = new Track();

    private RankingListTest() {
        t.newTrack("Bob Dylan", "All along the watchtower");
    }

    @Test
    public void TrackGetTrue(){
        Assert.assertEquals(t.getLastTrack(), "Bob DylanAll along the watchtower");
    }

    @Test
    public void TrackGetFalse(){
        Assert.assertNotSame(t.getLastTrack(), "Jimi HendrixAll along the watchtower");
    }

}
