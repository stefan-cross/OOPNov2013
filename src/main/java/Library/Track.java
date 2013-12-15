package Library;

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
        plays = 0;
        downloads = 0;
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
    public String toString(){
        return artist.getName() + " - " + title.getTitle() + " | Plays:" + plays + " Downloads:" + downloads;
    }

    public int getPlays(){
        return plays;
    }

    public void incPlays(){
        plays ++;
    }

    // Although we shouldn't need this in the actual app, its useful for testing and generating
    public void setPlays(int i){
        plays = i;
    }

    public int getDownloads(){
        return downloads;
    }

    public void incDownloads(){
        downloads++;
    }

    // Although we shouldn't need this in the actual app, its useful for testing and generating
    public void setDownloads(int i){
        downloads = i;
    }


}