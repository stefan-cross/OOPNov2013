package Library;

/**
 * User: stefancross
 * Date: 30/11/2013
 * Time: 18:03
 */
public class Track implements ITrack {

    // Vars
    private Artist artist;
    private Title title;
    private Plays plays;
    private Downloads downloads;


    // Constructor
    public Track(){

        artist = new Artist();
        title = new Title();

        plays = new Plays();
        downloads = new Downloads();
    }

    // Methods
    public Track setTrack(String artist, String title){
        this.artist.setArtist(artist);
        this.title.setTitle(title);
        return this;
    }

    public Track getTrack(){
        return this;
    }

    public int getTrackDownloads() {
        return downloads.getDownloads();
    }

    public Track setTrackDownloads(int i) {
        downloads.setDownloads(i);
        return this;
    }

    public void incTrackDownloads() {
        downloads.incDownloads();
    }

    public int getTrackPlays() {
        return plays.getPlays();
    }

    public Track setTrackPlays(int i) {
        plays.setPlays(i);
        return this;
    }

    public void incTrackPlays() {
        plays.incPlays();
    }

    public String getArtist() {
        return artist.getArtist().toString();
    }

    public void setArtist(String artist) {
        this.artist.setArtist(artist);
    }

    public String getTitle() {
        return title.getTitle().toString();
    }

    public void setTitle(String title) {
        this.title.setTitle(title);
    }

    @Override
    public String toString(){
        return artist.getArtist() + " - " + title.getTitle() + " | Plays:" + plays.getPlays() + " Downloads:" + downloads.getDownloads();
    }
}
