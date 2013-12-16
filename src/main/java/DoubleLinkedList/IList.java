package DoubleLinkedList;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 13/12/2013
 * Time: 14:35
 */
public interface IList<E> extends Iterable<E> {

    /* Overview: Returns the number of elements in the list
     * Precondition: none
     * Post-condition: none
     */
    public int size();

    /* Overview: Returns boolean value depending on elements in list
     * Precondition: none
     * Post-condition: none
     */
    public Boolean isEmpty();

    /* Overview: Returns the 1st element of the list
     * Precondition: none
     * Post-condition: none
     */
    public IPlacement<E> first() throws EmptyListException;

    /* Overview: Returns the last element of the list
     * Precondition: none
     * Post-condition: none
     */
    public IPlacement<E> last() throws EmptyListException;

    /* Overview: Inserts in front of the next element of the list
     * Precondition: none
     * Post-condition: none
     */

    public IPlacement<E> next(IPlacement<E> rank) throws EmptyListException, InvalidPlaceException;

    public IPlacement<E> insertNext(IPlacement<E> nextEl);

    /* Overview: Inserts in front of the previous element of the list
     * Precondition: none
     * Post-condition: none
     */
    public IPlacement<E> insertPrev(IPlacement<E> prevEl);


    /* Overview: adds the first element to the list
     * Precondition: none
     * Post-condition: none
     */
    public void addFirst(E e);

    /* Overview: adds an element to the list
     * Precondition: none
     * Post-condition: none
     */
    public void addElement(IPlacement<E> r, E e) throws InvalidPlaceException;


    /* Overview: Iterates over elements in the list
     * Precondition: none
     * Post-condition: none
     */
    public Iterator<E> iterator();




}
