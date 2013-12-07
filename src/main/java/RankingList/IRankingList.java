package RankingList;

//TODO these are stack methods, reconsider

//TODO although the spec refers to a list, consider the records as a list, no duplicate

public interface IRankingList {

    /* Overview: Track object to place into the list
     * Precondition: none
     * Post-condition: list size increases by 1
     *                the rest of the list is reordered by play count
     */
    public void push(Track track);

    /* Overview: Track object returned from the list
     * Precondition: none
     * Post-condition: list size decreases by 1
     *                the rest of the list is reordered by play count
     */
    public Track pop() throws ListException;

    /* Overview: Track object returned from list
     * Precondition: List is not empty
     * Post-condition: list remains unchanged
     */
    public Track top() throws ListException;

    /* Overview: Informs is the list is empty or not
     * Precondition: none
     * Post-condition: returns true is the list has elements
     *                 list reminds unchanged
     */
   public boolean isEmpty();

    /* Overview: Notifies of list size
     * Precondition: List is not empty
     * Post-condition: returns the number of elements in list
     *                 list remains unchanged
     */
    public int size();


//    public void iterator();
//
//    public void comparator();

}
