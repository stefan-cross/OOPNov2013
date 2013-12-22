package DoubleLinkedList;

/**
 * User: stefancross
 * Date: 14/12/2013
 * Time: 12:13
 */
public interface IPlacement<E> {

    public E element() throws InvalidPlaceException;
}
