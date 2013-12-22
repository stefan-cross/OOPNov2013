package Library;

/**
 * User: stefancross
 * Date: 30/11/2013
 * Time: 17:54
 */
public class Title implements ITitle{

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String toString(){
        return title;
    }
}
