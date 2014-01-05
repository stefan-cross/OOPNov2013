package ImLibrary;

/**
 * User: stefancross
 * Date: 30/11/2013
 * Time: 18:03
 */
public class Track implements ITrack {

    // Vars
    private final Artist artist;
    private final Title title;
    private final int downloadCount;


    // Constructor
    public Track(String newArtist, String newTitle, int downloads){
        artist = new Artist(newArtist);
        title = new Title(newTitle);
        downloadCount = downloads;
    }

    // Methods
    public Track getTrack(){
        return this;
    }

    public String getArtist() {
        return artist.getArtist().toString();
    }

    public String getTitle() {
        return title.getTitle().toString();
    }

    public int getDownloadCount(){
        return downloadCount;
    }

    @Override
    public String toString(){
        return "downloadCount - " + getDownloadCount() + " | Artist/Title " + artist.getArtist() + " - " + title.getTitle();
    }
}
