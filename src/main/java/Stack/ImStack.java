package Stack;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: stefancross
 * Date: 05/01/2014
 * Time: 00:01
 */
final public class ImStack<E> {

    private final E head;
    private final ImStack<E> tail;

    public ImStack(E h, ImStack<E> t){
        head = h;
        tail = t;
    }

    public boolean isEmpty(){
        if(head == null && tail == null){
            return true;
        } else {
            return false;
        }
    }

    public int size(){
        if(isEmpty()){
            return 0;
        } else {
            return tail.size()+1;
        }
    }

    public ImStack<E> pop(){
        return tail;
    }

    public ImStack<E> push(E head){
        return new ImStack<E>(head, this);
    }

    public E peek() throws StackException{
        if(head == null){
            throw new StackException("Head is null");
        }
        return head;
    }

    public Iterator<E> iterator() {
        StackIterator it = new StackIterator(this);
        return it;
    }
}
