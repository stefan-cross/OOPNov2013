package ImLibrary;

/**
 * User: stefancross
 * Date: 30/11/2013
 * Time: 17:54
 */
public class Title implements ITitle{

    private final String title;

    public Title(String t){
        title = t;
    }

    public String getTitle() {
        return title;
    }

    public String toString(){
        return title;
    }
}
