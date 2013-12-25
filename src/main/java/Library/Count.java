package Library;

/**
 * User: stefancross
 * Date: 22/12/2013
 * Time: 11:31
 */
public class Count implements ICount {

    private int count;

    public Count(){
        count = 0;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int i) {
        count = i;
    }

    public void incCount() {
        count++;
    }
}
