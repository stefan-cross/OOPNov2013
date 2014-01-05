package ImLibrary;

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
