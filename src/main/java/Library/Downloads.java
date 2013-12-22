package Library;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 22/12/2013
 * Time: 11:31
 */
public class Downloads implements IDownloads {

    private int downloads = 0;

    @Override
    public int getDownloads() {
        return downloads;
    }

    @Override
    public void setDownloads(int i) {
        downloads = i;
    }

    @Override
    public void incDownloads() {
        downloads++;
    }
}
