package Stack;

import Library.Track;

/**
 * User: stefancross
 * Date: 07/12/2013
 * Time: 14:14
 * To change this template use File | Settings | File Templates.
 */
public class LinkedNode {

    private Track item;
    private LinkedNode next;

    public LinkedNode(Track item){
        this.item = item;
        this.next = null;
    }

    public LinkedNode(Track item, LinkedNode next){
        this.item = item;
        this.next = next;
    }

    public void setItem(Track newItem){
        this.item = newItem;
    }

    public Track getItem(){
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
