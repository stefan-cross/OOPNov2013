package Stack;

import Library.Track;

/**
 * User: stefancross
 * Date: 07/12/2013
 * Time: 14:14
 */
public class LinkedNode<T> {

    private T item;
    private LinkedNode next;

    public LinkedNode(T item){
        this.item = item;
        this.next = null;
    }

    public LinkedNode(T item, LinkedNode next){
        this.item = item;
        this.next = next;
    }

    public void setItem(T newItem){
        this.item = newItem;
    }

    public T getItem(){
       return this.item;
    }

    public void setNext(LinkedNode newNext){
        this.next = newNext;
    }

    public LinkedNode getNext(){
        return this.next;
    }

    @Override
    public String toString(){
        return this.item.toString();
    }



}
