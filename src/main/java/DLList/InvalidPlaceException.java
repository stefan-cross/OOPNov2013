package DLList;

public class InvalidPlaceException extends Exception {

    public InvalidPlaceException(){
        super();
    }
    // Allow exception with additional message
    public InvalidPlaceException(String msg) {
        super(msg);
    }
}
