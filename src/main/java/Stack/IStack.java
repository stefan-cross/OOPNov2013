package Stack;

//TODO these are stack methods, reconsider

//TODO although the spec refers to a placementList, consider the records as a placementList, no duplicate

import Library.Track;

public interface IStack {

    /* Overview: Library.Track object to place into the placementList
     * Precondition: none
     * Post-condition: placementList size increases by 1
     *                the rest of the placementList is reordered by play count
     */
    public void push(Track track);

    /* Overview: Library.Track object returned from the placementList
     * Precondition: none
     * Post-condition: placementList size decreases by 1
     *                the rest of the placementList is reordered by play count
     */
    public Track pop() throws ListException;

    /* Overview: Library.Track object returned from placementList
     * Precondition: PlacementList is not empty
     * Post-condition: placementList remains unchanged
     */
    public Track top() throws ListException;

    /* Overview: Informs is the placementList is empty or not
     * Precondition: none
     * Post-condition: returns true is the placementList has elements
     *                 placementList reminds unchanged
     */
   public boolean isEmpty();

    /* Overview: Notifies of placementList size
     * Precondition: PlacementList is not empty
     * Post-condition: returns the number of elements in placementList
     *                 placementList remains unchanged
     */
    public int size();


//    public void iterator();
//
//    public void comparator();

}
