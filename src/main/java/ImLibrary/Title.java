package ImLibrary;

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
