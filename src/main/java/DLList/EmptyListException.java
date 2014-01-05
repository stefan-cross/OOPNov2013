package DLList;

public class EmptyListException extends Exception {

    public EmptyListException(){
        super();
    }

    public EmptyListException(String msg) {
        super(msg);
    }
}
