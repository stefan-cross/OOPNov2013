package Library;

/**
 * User: stefancross
 * Date: 30/11/2013
 * Time: 17:55
 */
public class Artist implements IArtist {

    private String artist;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String toString(){
        return artist;
    }
}
