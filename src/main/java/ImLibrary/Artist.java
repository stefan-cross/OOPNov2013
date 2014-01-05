package ImLibrary;

/**
 * User: stefancross
 * Date: 30/11/2013
 * Time: 17:55
 */
public class Artist implements IArtist {

    private final String artist;

    public Artist(String a){
        artist = a;
    }

    public String getArtist() {
        return artist;
    }

    public String toString(){
        return artist;
    }
}
