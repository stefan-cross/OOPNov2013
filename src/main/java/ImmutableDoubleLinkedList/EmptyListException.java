package ImmutableDoubleLinkedList;

/**
 * User: stefancross
 * Date: 14/12/2013
 * Time: 12:45
 */
public class EmptyListException extends Exception {

    public EmptyListException(){
        super();
    }

    public EmptyListException(String msg) {
        super(msg);
    }
}
