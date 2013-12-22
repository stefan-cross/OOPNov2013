package Library;

/**
 * User: stefancross
 * Date: 30/11/2013
 * Time: 17:53
 */
public interface ITrack{

    public Track setTrack(String artist, String title);
    public Track getTrack();
    public int getTrackDownloads();
    public void incTrackDownloads();
    public Track setTrackDownloads(int i);
    public int getTrackPlays();
    public void incTrackPlays();
    public Track setTrackPlays(int i);

}
