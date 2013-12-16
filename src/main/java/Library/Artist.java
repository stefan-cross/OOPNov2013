package Library;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 30/11/2013
 * Time: 17:55
 * To change this template use File | Settings | File Templates.
 */
public class Artist implements IArtist {

    private String name;

    //TODO why get and set name? Make it get and set artist for consistency!
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // When we cast an Artist to String, this will be called
    public String toString(){
        return name;
    }
}
