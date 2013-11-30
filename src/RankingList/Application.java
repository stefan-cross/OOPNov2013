package RankingList;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 30/11/2013
 * Time: 17:51
 * To change this template use File | Settings | File Templates.
 */
public class Application {

    public static void main(String[] args){

        System.out.println("Application.Main running...");

        Track track1 = new Track();
        track1.newTrack("Bob Dylan", "All along the watchtower");

        System.out.println(track1.toString());
        System.out.println(track1.getLastTrack());
    }

}
