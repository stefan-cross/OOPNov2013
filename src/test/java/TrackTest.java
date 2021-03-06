import Library.Track;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 06/12/2013
 * Time: 18:12
 * To change this template use File | Settings | File Templates.
 */
public class TrackTest {

    private static Track t = new Track();

    public TrackTest() {
        t.setTrack("Bob Dylan", "All along the watchtower");
    }

    @Test
    public void TrackGetTrue(){
        Assert.assertEquals("Bob Dylan - All along the watchtower", t.toString());
    }

    @Test
    public void TrackGetFalse(){
        Assert.assertNotSame("Jimi Hendrix - All along the watchtower", t.toString());
    }
}
