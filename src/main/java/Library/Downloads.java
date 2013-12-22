package Library;

/**
 * User: stefancross
 * Date: 22/12/2013
 * Time: 11:31
 */
public class Downloads implements IDownloads {

    private int downloads = 0;

    public int getDownloads() {
        return downloads;
    }

    public void setDownloads(int i) {
        downloads = i;
    }

    public void incDownloads() {
        downloads++;
    }
}
