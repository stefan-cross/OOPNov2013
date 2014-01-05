package Library;

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
