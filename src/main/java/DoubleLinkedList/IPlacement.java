package DoubleLinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 14/12/2013
 * Time: 12:13
 */
public interface IPlacement<E> {

    // Returns an object at a given ranking
    public E element() throws InvalidPlaceException;
}
