package DLList;

public class EmptyListException extends Exception {

    public EmptyListException(){
        super();
    }
    // Allow exception with additional message
    public EmptyListException(String msg) {
        super(msg);
    }
}
