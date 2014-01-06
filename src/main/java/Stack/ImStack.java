package Stack;

import java.util.Iterator;

final public class ImStack<E> implements IStack<E>{
    // Note final class and vars for immutability
    private final E head;
    private final ImStack<E> tail;

    // Constructor sets new tail object
    public ImStack(E h, ImStack<E> t){
        head = h;
        tail = t;
    }

    // returns true is there are no items in stack
    public boolean isEmpty(){
        if(head == null && tail == null){
            return true;
        } else {
            return false;
        }
    }

    // returns number of items in stack
    public int size(){
        if(isEmpty()){
            return 0;
        } else {
            return tail.size()+1;
        }
    }

    // returns the next element
    public ImStack<E> pop() {
        return tail;
    }

    // adds a new item to the stack by means of constructor
    public ImStack<E> push(E head){
        return new ImStack<E>(head, this);
    }

    // reveals the head node and handles null head as empty stack
    public E peek() throws StackException{
        if(head == null){
            throw new StackException("Head is null");
        }
        return head;
    }

    // creates new iterator of stack
    public Iterator<ImStack<E>> iterator() {
        return  new StackIterator(this);
    }
}
