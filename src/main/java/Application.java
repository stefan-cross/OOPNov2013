import RankingList.Track;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 30/11/2013
 * Time: 17:51
 * To change this template use File | Settings | File Templates.
 */
public class Application {

    public static void main(String[] args){

        System.out.println("App running.");

        Track track1 = new Track();
        track1.setTrack("Bob Dylan", "All along the watchtower");

        System.out.println(track1.getTrack());
    }

}
