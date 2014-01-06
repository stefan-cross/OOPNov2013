package Stack;

import java.util.Iterator;

public interface IStack<T> {

    /* Overview: TGeneric object to place into the stack
     * Precondition: none
     * Post-condition: size increases by 1
     */
    public ImStack push(T t);

    /* Overview: TGeneric object returned from the stack
     * Precondition: none
     * Post-condition: stack size decreases by 1
     */
    public ImStack pop() throws StackException;

    /* Overview: TGeneric object returned from stack
     * Precondition: PlacementList is not empty
     * Post-condition: stack remains unchanged
     */
    public T peek() throws StackException;

    /* Overview: Informs is the stack is empty or not
     * Precondition: none
     * Post-condition: returns true is the stack has elements
     *                 stack reminds unchanged
     */
   public boolean isEmpty();

    /* Overview: Notifies of stack size
     * Precondition: PlacementList is not empty
     * Post-condition: returns the number of elements in stack
     *                 stack remains unchanged
     */
    public int size();

    /* Overview: Moves through the stack
     * Precondition: PlacementList is not empty
     * Post-condition: returns the number of elements in stack
     *                 stack remains unchanged
     */
    public Iterator<ImStack<T>> iterator();


}
