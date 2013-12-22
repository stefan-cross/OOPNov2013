package Library;

/**
 * User: stefancross
 * Date: 22/12/2013
 * Time: 11:28
 */
public class Plays implements IPlays{

    private int plays = 0;

    public int getPlays() {
        return plays;
    }

    public void setPlays(int i) {
        plays = i;
    }

    public void incPlays() {
        plays++;
    }
}
