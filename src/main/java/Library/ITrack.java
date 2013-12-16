package Library;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 30/11/2013
 * Time: 17:53
 * To change this template use File | Settings | File Templates.
 */
public interface ITrack extends IArtist, ITitle {

    public void setTrack(String artist, String title);
    public Track getTrack();
    public int getDownloads();
    public void incDownloads();
    public void setDownloads(int i);
    public int getPlays();
    public void incPlays();
    public void setPlays(int i);

}
