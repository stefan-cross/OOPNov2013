package RankingList;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 13/12/2013
 * Time: 14:35
 */
public interface IRankingList {

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
    public Object first();

    /* Overview: Returns the last element of the list
     * Precondition: none
     * Post-condition: none
     */
    public Object last();

    /* Overview: Returns the next element of the list
     * Precondition: none
     * Post-condition: none
     */
    public Object next();

    /* Overview: Adds an element to the list
     * Precondition: none
     * Post-condition: none
     */
    public void addElement();



}
