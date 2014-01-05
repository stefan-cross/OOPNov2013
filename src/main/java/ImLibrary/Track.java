package ImLibrary;

final public class Track implements ITrack {

    // Vars, final for immutability
    private final Artist artist;
    private final Title title;
    private final int downloadCount;


    // Constructor designed for immutability
    public Track(String newArtist, String newTitle, int downloads){
        artist = new Artist(newArtist);
        title = new Title(newTitle);
        downloadCount = downloads;
    }

    // Methods, only accessor
    public Track getTrack(){return this;}

    public String getArtist() {return artist.getArtist().toString();}

    public String getTitle() {return title.getTitle().toString();}

    public int getDownloadCount(){
        return downloadCount;
    }

    @Override
    public String toString(){
        return "downloadCount: " + getDownloadCount() + " | Artist/Title " + artist.getArtist() + " - " + title.getTitle();
    }
}
