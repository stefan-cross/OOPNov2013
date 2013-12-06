package RankingList;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 30/11/2013
 * Time: 18:03
 * To change this template use File | Settings | File Templates.
 */
public class Track implements ITrack {

    // Vars
    private Artist artist;
    private Title title;

    private int plays;
    private int downloads;


    // Constructor
    public Track(){
        title = new Title();
        artist = new Artist();
    }

    // Methods
    public void setTrack(String artist, String title){
        this.artist.setName(artist);
        this.title.setTitle(title);
    }

    public Track getTrack(){
        return this;
    }

    @Override
    public String toString() {
        return artist.getName() + "-" + title.getTitle();
    }


}
