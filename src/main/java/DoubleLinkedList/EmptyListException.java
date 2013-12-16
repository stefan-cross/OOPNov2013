package DoubleLinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 14/12/2013
 * Time: 12:45
 * To change this template use File | Settings | File Templates.
 */
public class EmptyListException extends Exception {

    public EmptyListException(){
        super();
    }

    public EmptyListException(String msg) {
        super(msg);
    }
}
