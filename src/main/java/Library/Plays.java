package Library;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 22/12/2013
 * Time: 11:28
 */
public class Plays implements IPlays{

    private int plays = 0;
    @Override
    public int getPlays() {
        return plays;
    }

    @Override
    public void setPlays(int i) {
        plays = i;
    }

    @Override
    public void incPlays() {
        plays++;
    }
}
