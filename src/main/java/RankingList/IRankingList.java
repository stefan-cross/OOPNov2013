package RankingList;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 13/12/2013
 * Time: 14:35
 */
public interface IRankingList<E> {

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
    public IRank<E> first() throws EmptyListException;

    /* Overview: Returns the last element of the list
     * Precondition: none
     * Post-condition: none
     */
    public IRank<E> last() throws EmptyListException;

    /* Overview: Inserts in front of the next element of the list
     * Precondition: none
     * Post-condition: none
     */
    public IRank<E> insertNext(IRank<E> nextEl);

    /* Overview: Inserts in front of the previous element of the list
     * Precondition: none
     * Post-condition: none
     */
    public IRank<E> insertPrev(IRank<E> prevEl);

    /* Overview: adds an element to the list
     * Precondition: none
     * Post-condition: none
     */
    public void addElement(E e) throws InvalidPlaceException;

    /* Overview: Removes an element to the list
     * Precondition: none
     * Post-condition: none
     */
    public E removeElement(E e) throws InvalidPlaceException;

}
