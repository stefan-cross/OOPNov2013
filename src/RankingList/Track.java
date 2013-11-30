package RankingList;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 30/11/2013
 * Time: 18:03
 * To change this template use File | Settings | File Templates.
 */
public class Track {

    private Artist artist = new Artist();
    private Title title = new Title();

    public void newTrack(String artist, String title){
        this.artist.setName(artist);
        this.title.setTitle(title);
    }

    public String getLastTrack(){
        return artist.getName() + title.getTitle();
    }


}
