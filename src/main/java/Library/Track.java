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
    private int count;


    // Constructor
    public Track(){
        artist = new Artist();
        title = new Title();
        //count = 0;
    }

    // Methods
    public Track setTrack(String artist, String title){
        this.artist.setArtist(artist);
        this.title.setTitle(title);
        //this.count = count;
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

//    public int getCount() {
//        return count;
//    }
//
//    public Track setCount(int i) {
//        count = i;
//        return this;
//    }
//
//    public void incCount() {
//        count++;
//    }

    @Override
    public String toString(){
        return artist.getArtist() + " - " + title.getTitle(); //+ " Count:" + count;
    }
}
