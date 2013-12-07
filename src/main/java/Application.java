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

        // TODO move the following into a generator to pre-populate some data into the system
        Track track1 = new Track();
        track1.setTrack("Bob Dylan", "All along the watchtower");
        track1.incDownloads();
        track1.incPlays();track1.incPlays();track1.incPlays();
        System.out.println(track1.getTrack());


        Track track2 = new Track();
        track2.setTrack("Bob Marley", "Redemption Song");
        track2.setDownloads(2);
        track2.setPlays(5);
        System.out.println(track2.getTrack());

        //TODO Look into a cmdln interface with options for adding tracks
        //TODO cmdln interface to return ranking by count or download or most popular artists track

    }

}
