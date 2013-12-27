package Tree;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 27/12/2013
 * Time: 14:40
 */
public class EmptyTreeException extends Exception {

    public EmptyTreeException(){
        super();
    }

    public EmptyTreeException(String msg) {
        super(msg);
    }
}
