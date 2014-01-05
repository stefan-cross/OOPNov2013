package ImLibrary;

final public class Title implements ITitle{
    // Note final var and only accessor method for immutability
    private final String title;

    public Title(String t){ title = t;}

    public String getTitle() {
        return title;
    }

    public String toString(){
        return title;
    }
}
