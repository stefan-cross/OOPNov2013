package Library;

public class Track implements ITrack {

    // Vars
    private Artist artist;
    private Title title;

    // Constructor
    public Track(){
        artist = new Artist();
        title = new Title();
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
        return artist.getArtist() + " - " + title.getTitle();
    }
}
